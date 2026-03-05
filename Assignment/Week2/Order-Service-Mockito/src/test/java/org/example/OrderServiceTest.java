package org.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.example.OrderService;
import org.example.PaymentGateway;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
public class OrderServiceTest {

    @Mock
    PaymentGateway paymentGatewayMock;

    @InjectMocks
    OrderService orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        System.out.println("\n=== Setting up fresh mocks for next test ===");
    }

    @Test
    @DisplayName("Test successful order placement")
    void testPlaceOrder_Success() {

        when(paymentGatewayMock.processPayment(2000.0)).thenReturn(true);

        String result = orderService.placeOrder(2000.0);

        System.out.println("Result = " + result);

        assertTrue("ORDER Confirmed".equalsIgnoreCase(result));

        verify(paymentGatewayMock).processPayment(2000.0);
    }

    @Test
    @DisplayName("Test Invalid Order Amount")
    void testInvalidOrderAmount() {

        when(paymentGatewayMock.processPayment(0.0)).
        thenThrow(new IllegalArgumentException("Invalid Amount !"));

        IllegalArgumentException exception = 
        		assertThrows(IllegalArgumentException.class,() -> orderService.placeOrder(0.0));
        System.out.println("Exception = "+exception.getMessage());
    }
    @Test
    @DisplayName("Test when payment failure")
    void testPaymentFailure() {
    	
        when(paymentGatewayMock.processPayment(1500.0))
                .thenThrow(new RuntimeException("Payment failed!"));

        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> orderService.placeOrder(1500.0)
        );

        System.out.println("Exception = " + exception.getMessage());

        verify(paymentGatewayMock).processPayment(1500.0);
    }
}
