package com.scaler.flipkart.Controler;

import com.scaler.flipkart.Models.Category;
import com.scaler.flipkart.Models.Product;
import com.scaler.flipkart.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController (ProductService productService){

        this.productService = productService;
    }
    @GetMapping("/Product/{id}")
    public Product getProduct(@PathVariable("id") Long productid ){
        Product product = productService.getSingleProduct(productid);
         return product;
    }
    @GetMapping("/Products")
    public List<Product> getListOfProduct(){
        List<Product> p = productService.getAllProduct();
        return p;
    }
    @GetMapping("/Product/Category/{category}")
    public  List<Product> getProductBycategory  (@PathVariable ("category") String cat){
        List<Product> pr = productService.findProductByCategory(cat);
        return pr;
    }

    @GetMapping("/Categorys")
    public List<Category> getListOfCategory(){
        List<Category> c = productService.getAllCategory();
        return c;
    }
     @PostMapping("/Product")
    public Product makeProduct (@RequestBody Product product){
        Product p = productService.createProduct(product);
          return p;
     }

     @PutMapping("/Product")
    public Product upDateProduct (@RequestBody() Product product ){
        Product p = productService.modifyProductDetails(product);
        return p;

     }
     @PatchMapping("/Product")
     public Product upDateField (@RequestBody() Product product){
        Product p = productService.upDateProductDetail(product);
        return p;
     }
     @DeleteMapping("/Product/{id}")
    public void removeProduct (@PathVariable("id")  Long productId){
           productService. deleteAproduct(productId);

     }
}
