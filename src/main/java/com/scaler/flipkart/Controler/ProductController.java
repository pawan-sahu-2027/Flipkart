package com.scaler.flipkart.Controler;

import com.scaler.flipkart.Dto.ErrorDto;
import com.scaler.flipkart.Models.Category;
import com.scaler.flipkart.Models.Product;
import com.scaler.flipkart.Service.ProductService;
import com.scaler.flipkart.Service.SelfProductService;
import com.scaler.flipkart.exceptions.CategoryNotFoundException;
import com.scaler.flipkart.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @Qualifier("selfProductService")
    private ProductService productService;
    private SelfProductService selfProductService;

    public ProductController (@Qualifier("selfProductService") ProductService productService, SelfProductService selfProductService){

        this.productService = productService;
        this.selfProductService = selfProductService;
    }
    @GetMapping("/Product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long productid ) throws ProductNotFoundException {
           ResponseEntity< Product> product = productService.getSingleProduct(productid);
         return product;
    }
    @GetMapping("/Products")
    public List<Product> getListOfProduct() throws ProductNotFoundException {
        List<Product> productList = productService.getAllProduct();
          if (productList == null){
              throw new ProductNotFoundException("this is no product available ");
          }
        return productList;
    }
    @GetMapping("/Product/Category/{category}")
    public  List<Product> getProductBycategory  (@PathVariable ("category") String cat) throws CategoryNotFoundException , ProductNotFoundException {
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
        return selfProductService.createProduct(product);
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
    public void removeProduct (@PathVariable("id")  Long productId) throws ProductNotFoundException{
           productService.deleteAproduct(productId);

     }

     @ExceptionHandler(CategoryNotFoundException.class)
     public ResponseEntity<ErrorDto> handleCategoryNotFound (Exception f){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(f.getMessage());
        return new ResponseEntity<>(errorDto , HttpStatus.NOT_FOUND);
     }

     @ExceptionHandler(ProductNotFoundException.class)
     public ResponseEntity<ErrorDto> handleProductNotFound (Exception e){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(e.getMessage());
        return new ResponseEntity<>(errorDto , HttpStatus.NOT_FOUND);
     }
}
