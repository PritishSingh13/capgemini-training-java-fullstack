package org.example.ProductApp.Model;


import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Positive;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Product {
    private Long id;

    @NotBlank(message  = "Name is required")
    private String name;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private double price;
    @NotNull(message = "Quantity is required")
    @Min(value = 1,message = "Quantity must be at Least 1")
    @Max( value = 20,message = "Quantity must be at most 20")

    private Integer quantity;

    public Product(Long id, String name, double price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}