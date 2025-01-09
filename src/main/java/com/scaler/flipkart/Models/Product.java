package com.scaler.flipkart.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Long id;
    private String tital;
    private double price;
    private String description;
    private String imageUrl;
    private Category category;
}
