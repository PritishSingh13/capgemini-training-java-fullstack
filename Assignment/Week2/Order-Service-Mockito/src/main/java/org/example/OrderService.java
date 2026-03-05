package org.example;

public class OrderService {

    private PaymentGateway paymentGateway;

    public OrderService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public String placeOrder(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid Order Amount");
        }

        boolean paymentStatus = paymentGateway.processPayment(amount);

        if (!paymentStatus) {
            throw new RuntimeException("Payment Failed");
        }

        return "Order Confirmed";
    }
}
