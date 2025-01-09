package com.scaler.flipkart.Dto;

import com.scaler.flipkart.Models.Category;
import com.scaler.flipkart.Models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FakeStoreProductDto {
    private Long   id;
    private String title;
    private double price;
    private String image;
    private String description;
    private String category;


    public Product toProduct (){
        Product p = new Product();
        Category c  = new Category();
        c.setTitle(category);
        p.setCategory(c);
        p.setId(id);
        p.setTital(title);
        p.setPrice(price);
        p.setImageUrl(image);
        p.setDescription(description);


        return p;
    }
}
