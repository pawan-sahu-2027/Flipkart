package com.scaler.flipkart.Service;

import com.scaler.flipkart.Configer.ApplicationConfiguaration;
import com.scaler.flipkart.Dto.FakeStoreProductDto;
import com.scaler.flipkart.Models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements  ProductService{
    private RestTemplate restTemplate;
    public FakeStoreProductService (RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        FakeStoreProductDto p  = restTemplate.getForObject("https://fakestoreapi.com/products/"
                + productId , FakeStoreProductDto.class);
        return p.toProduct();
    }
}
