package com.scaler.flipkart.Service;

import com.scaler.flipkart.Models.Category;
import com.scaler.flipkart.Models.Product;
import com.scaler.flipkart.Repository.CategoryRepository;
import com.scaler.flipkart.Repository.ProductRepository;
import com.scaler.flipkart.exceptions.CategoryNotFoundException;
import com.scaler.flipkart.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService{
    //private final ProductController productController;
    private  ProductRepository productRepository;
    private  CategoryRepository categoryRepository;
    public SelfProductService(ProductRepository productRepository , CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
      //  this.productController = productController;
    }
    @Override
    public ResponseEntity<Product> getSingleProduct(Long id) throws ProductNotFoundException {
        Product product =  productRepository.getById(id);
               if (product == null){
                   throw new ProductNotFoundException("Their is no Product with this Id" + id);
               }
        return new  ResponseEntity<>(product , HttpStatus.OK);
    }

    @Override
    public List<Product> getAllProduct() throws ProductNotFoundException {
        List<Product> productList = productRepository.findAll();
         if (productList == null){
             throw new  ProductNotFoundException (" Their is no Product available ");
         }
        return productList;
    }

    @Override
    public List<Product> findProductByCategory(String category) throws CategoryNotFoundException , ProductNotFoundException {
          Category cat = categoryRepository.findByTitle(category);
           if(cat == null){
               throw  new CategoryNotFoundException("their is no category exist by this name  " + category);
           }
        List <Product> pr = categoryRepository.findAllByTitle (category);
           if (pr == null){
               throw new ProductNotFoundException(" their is no product with this category " + category);
           }
        return null;
    }

    @Override
    public List<Category> getAllCategory() {
       List <Category> catList = categoryRepository.findAll();
        return  catList;
    }

//    {
//        "id": 1,
//            "title": "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
//            "price": 100.95,
//            "description": "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
//            "imageUrl": "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
//            "category": {
//        "id": 1,
//                "title": "men's clothing"
//    }
//    }

    @Override
    public Product createProduct(Product product) {
        Category cat = categoryRepository.findByTitle(product.getCategory().getTitle());
        if (cat == null) {
            Category newCat = new Category();
            newCat.setTitle(product.getCategory().getTitle());
            newCat.setId(product.getCategory().getId());
            cat = newCat;
            categoryRepository.save(cat);
        }
        Product p = new Product();
        p.setPrice(product.getPrice());
        p.setImageUrl(product.getImageUrl());
        p.setTitle(product.getTitle());
        p.setCategory(cat);
        p.setDescription(product.getDescription());
        return productRepository.save(p);

    }

    @Override
    public Product modifyProductDetails(Product product) throws ProductNotFoundException {
        Product p = productRepository.getById(product.getId());
        Optional<Product> pro = productRepository.findById(product.getId());
          if (pro.isEmpty()){
              throw new ProductNotFoundException(" this is no product available with Id" + product.getId());
          }
          else {
              p.setDescription(product.getDescription());
              p.setPrice(product.getPrice());
              p.setImageUrl(product.getImageUrl());

          }
        Product upDatedProduct = productRepository.save(p);
        return upDatedProduct;
    }

    @Override
    public Product upDateProductDetail(Product product) throws ProductNotFoundException {
        Product p = productRepository.getById(product.getId());
        Optional <Product> pro = productRepository.findById(product.getId());
        if (pro.isEmpty()){
            throw new ProductNotFoundException(" this is no product available with Id" + product.getId());
        }
        else {
            p.setDescription(product.getDescription());
            p.setPrice(product.getPrice());
            p.setImageUrl(product.getImageUrl());

        }
        Product upDatedProduct = productRepository.save(p);
        return upDatedProduct;
    }

    @Override
    public void deleteAproduct(Long productId) throws ProductNotFoundException {
        Product p = productRepository.getById(productId);

        if (p == null){
            throw new ProductNotFoundException(" this product do not exist in the repository / Dara Base");
        }
        productRepository .deleteById(productId);

    }
}
