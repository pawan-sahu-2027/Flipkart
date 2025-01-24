package com.scaler.flipkart.Repository;

import com.scaler.flipkart.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product , Long> {
}
