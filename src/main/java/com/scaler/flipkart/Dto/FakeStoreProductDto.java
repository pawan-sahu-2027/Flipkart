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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTile() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Product toProduct (){
        Product p = new Product();
        Category c  = new Category();
        c.setTitle(category);
        p.setCategory(c);
        p.setId(id);
        p.setTitle(title);
        p.setPrice(price);
        p.setImageUrl(image);
        p.setDescription(description);


        return p;
    }
}
