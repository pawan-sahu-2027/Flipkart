package com.scaler.flipkart.exceptions;

import com.scaler.flipkart.Repository.CategoryRepository;

public class CategoryNotFoundException extends Exception{
    public CategoryNotFoundException (String message){
        super(message);
    }
}
