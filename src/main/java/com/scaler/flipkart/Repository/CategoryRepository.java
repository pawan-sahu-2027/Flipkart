package com.scaler.flipkart.Repository;

import com.scaler.flipkart.Models.Category;
import com.scaler.flipkart.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category , Long> {
    Category findByTitle(String title);

    List<Product> findAllByTitle(String category);
}
