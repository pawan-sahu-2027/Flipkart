package com.scaler.flipkart.Service;

import com.scaler.flipkart.Models.Category;
import com.scaler.flipkart.Models.Product;
import com.scaler.flipkart.exceptions.CategoryNotFoundException;
import com.scaler.flipkart.exceptions.ProductNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
      ResponseEntity <Product> getSingleProduct(Long id) throws ProductNotFoundException;
     List<Product> getAllProduct() throws ProductNotFoundException;
     List<Product> findProductByCategory(String category) throws CategoryNotFoundException , ProductNotFoundException;
     List<Category> getAllCategory();
     Product createProduct(Product product);
     Product modifyProductDetails(Product product);
     Product upDateProductDetail (Product product);
     void  deleteAproduct(Long productId) throws ProductNotFoundException;
}
