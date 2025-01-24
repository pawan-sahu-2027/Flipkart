package com.scaler.flipkart.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category extends BaseModel{
//    public List<Product> getListOfProduct() {
//        return listOfProduct;
//    }
//
//    public void setListOfProduct(List<Product> listOfProduct) {
//        this.listOfProduct = listOfProduct;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    private String title;
}
