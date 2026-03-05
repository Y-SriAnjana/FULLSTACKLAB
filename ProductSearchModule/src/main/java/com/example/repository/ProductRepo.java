package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    // Derived query methods
    List<Product> findByCategory(String category);

    List<Product> findByPriceBetween(double min, double max);

    // a) Sort products by price
    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> sortByPrice();

    // b) Fetch products above a price
    @Query("SELECT p FROM Product p WHERE p.price > :price")
    List<Product> findExpensiveProducts(@Param("price") double price);

    // c) Fetch products by category
    @Query("SELECT p FROM Product p WHERE p.category = :category")
    List<Product> fetchByCategory(@Param("category") String category);
}