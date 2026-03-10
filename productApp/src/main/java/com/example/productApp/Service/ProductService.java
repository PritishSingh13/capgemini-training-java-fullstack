package com.example.productApp.Service;

import com.example.productApp.Model.Product;
import com.example.productApp.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    // Save or update product
    public void saveProduct(Product product) {
        repository.save(product);
    }

    // Get all products
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    // Get product by ID
    public Optional<Product> getProductById(Long id) {
        return repository.findById(id);
    }

    // Delete product by ID
    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}