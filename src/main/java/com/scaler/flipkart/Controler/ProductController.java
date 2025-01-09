package com.scaler.flipkart.Controler;

import com.scaler.flipkart.Models.Product;
import com.scaler.flipkart.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    public ProductController (ProductService productService){

        this.productService = productService;
    }
    @GetMapping("/Product/{id}")
    public Product getProduct(@PathVariable("id") Long productid ){
        Product product = productService.getSingleProduct(productid);
         return product;
    }
}
