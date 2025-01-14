package com.scaler.flipkart.Service;

import com.scaler.flipkart.Models.Category;
import com.scaler.flipkart.Models.Product;

import java.util.List;

public interface ProductService {
     Product getSingleProduct(Long id);
     List<Product> getAllProduct();
     List<Product> findProductByCategory(String category);
     List<Category> getAllCategory();
     Product createProduct(Product product);
     Product modifyProductDetails(Product product);
     Product upDateProductDetail (Product product);
     void  deleteAproduct(Long productId);
}
