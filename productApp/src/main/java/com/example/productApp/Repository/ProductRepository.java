package com.example.productApp.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.productApp.Model.Product;

@Repository
public class ProductRepository {
    private final List<Product> productList = new ArrayList<>();
    private Long idCounter = 1L;

    // Get all products
    public List<Product> findAll() {
        return productList;
    }

    // Save or update product
    public void save(Product product) {
        if (product.getId() == 0) { // default long is 0, not null
            product.setId(idCounter++);
            productList.add(product);
        } else {
            update(product);
        }
    }

    // Update existing product
    private void update(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()) {
                productList.set(i, product);
                break;
            }
        }
    }

    // Find product by ID
    public Optional<Product> findById(Long id) {
        return productList.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }

    // Delete product by ID
    public void deleteById(Long id) {
        productList.removeIf(p -> p.getId() == id);
    }
}