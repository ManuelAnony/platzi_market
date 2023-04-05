package com.platzi.cursoplatzi.domain.repository;

import com.platzi.cursoplatzi.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProducts(int productId);
    Product save(Product product);
    void delete(int productId);
}
