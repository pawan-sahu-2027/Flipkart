package com.scaler.flipkart.Service;
import com.scaler.flipkart.Dto.CategoryDto;
import com.scaler.flipkart.Dto.FakeStoreCategoryDto;
import com.scaler.flipkart.Dto.FakeStoreProductDto;
import com.scaler.flipkart.Models.Category;
import com.scaler.flipkart.Models.Product;
import com.scaler.flipkart.exceptions.CategoryNotFoundException;
import com.scaler.flipkart.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements  ProductService{
    private RestTemplate restTemplate;
    public FakeStoreProductService (RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<Product> getSingleProduct(Long productId) throws ProductNotFoundException {
//        FakeStoreProductDto p  = restTemplate.getForObject("https://fakestoreapi.com/products/"
//                + productId , FakeStoreProductDto.class);
//
//             return p.toProduct();
        ResponseEntity<FakeStoreProductDto> p  = restTemplate.getForEntity("https://fakestoreapi.com/products/"
                + productId , FakeStoreProductDto.class);

        if (p.getBody() == null){
            throw new ProductNotFoundException(" Product not found with Id" + productId);
        }

//       return ResponseEntity.status(p.getStatusCode()).body(p.getBody().toProduct());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(p.getBody().toProduct());


    }
    public List<Product> getAllProduct (){
        List<Product> list = new ArrayList<>();
         FakeStoreProductDto [] p = restTemplate.getForObject("https://fakestoreapi.com/products" ,  FakeStoreProductDto[].class );
         for (FakeStoreProductDto i : p ){
              list.add(i.toProduct());
         }
        return list;
    }

    @Override
    public List<Product> findProductByCategory(String category)  throws CategoryNotFoundException, ProductNotFoundException{
        //  CategoryDto categoryDto  = restTemplate.getForObject()
        List<Product> productList = new ArrayList<>();
        FakeStoreProductDto [] fakeStoreProductDtos = restTemplate.getForObject
                ("https://fakestoreapi.com/products/category/" +category  , FakeStoreProductDto[].class  );
        for (FakeStoreProductDto i : fakeStoreProductDtos){
            productList.add(i.toProduct());
        }
        return productList;
    }

    @Override
    public List<Category> getAllCategory() {
        List<Category> c = new ArrayList<>();
        CategoryDto [] categoryDto = restTemplate.getForObject
                ("https://fakestoreapi.com/products/categories" , CategoryDto[].class);
          for (CategoryDto i : categoryDto){
               Category t = new Category();
               t.setTitle(i.getCategory());
              c.add(t);
          }
        return c;
    }

    @Override
    public Product createProduct(Product product) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setImage(product.getImageUrl());
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setCategory(product.getCategory().getTitle());
        fakeStoreProductDto.setPrice(product.getPrice());
         FakeStoreProductDto f = restTemplate.postForObject("https://fakestoreapi.com/products",fakeStoreProductDto , FakeStoreProductDto.class);
        return f.toProduct();
    }

    @Override
    public Product modifyProductDetails(Product product) {
        FakeStoreProductDto fsp = restTemplate.getForObject("https://fakestoreapi.com/products/"
                + product.getId(), FakeStoreProductDto.class);

          fsp.setTitle(product.getTitle());
         // fsp.setPrice(product.getPrice());
          fsp.setImage(product.getImageUrl());
         // fsp.setDescription(product.getDescription());
          fsp.setCategory(product.getCategory().getTitle());

      restTemplate.put("https://fakestoreapi.com/products/" + product.getId() ,fsp );


        return  fsp.toProduct();
    }


    @Override
    public Product upDateProductDetail(Product product) {
        FakeStoreProductDto fsp = restTemplate.getForObject("https://fakestoreapi.com/products/"
                + product.getId(), FakeStoreProductDto.class);
          fsp.setId(product.getId());
          fsp.setTitle(product.getTitle());
          FakeStoreProductDto fs = restTemplate.patchForObject("https://fakestoreapi.com/products/"
                  + product.getId() , fsp , FakeStoreProductDto.class);

        return fsp.toProduct();
    }
     public  void   deleteAproduct(Long productId) throws ProductNotFoundException {

            FakeStoreProductDto fr = restTemplate.getForObject("https://fakestoreapi.com/products/" + productId , FakeStoreProductDto.class);
            if (fr == null){
                throw new ProductNotFoundException ("Their is no product exist  with this Id " + productId);
            }
            restTemplate.delete("https://fakestoreapi.com/products/" + productId);

     }

}

