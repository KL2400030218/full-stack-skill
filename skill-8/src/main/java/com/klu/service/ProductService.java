package com.klu.service;

import org.springframework.stereotype.Service;

import com.klu.entity.Product;
import com.klu.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getProductsByCategory(String category) {
        return repo.findByCategory(category);
    }

    public List<Product> getProductsByPriceRange(double min, double max) {
        return repo.findByPriceBetween(min, max);
    }

    public List<Product> getSortedProducts() {
        return repo.getProductsSortedByPrice();
    }

    public List<Product> getExpensiveProducts(double price) {
        return repo.getExpensiveProducts(price);
    }
}