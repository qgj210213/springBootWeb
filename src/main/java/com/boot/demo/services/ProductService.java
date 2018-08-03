package com.boot.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.demo.dao.ProductRepositry;
import com.boot.demo.persistBean.Product;

@Service
public class ProductService {
    @Autowired
    ProductRepositry ptStory;

    public void addProduct() {
        Product product = new Product();
        product.setGoodName("春天里");
        product.setGoodType("CD");
        product.setPrice(25.04);
        ptStory.save(product);
        Product product2 = new Product();
        product2.setGoodName("巧克力");
        product2.setGoodType("CD");
        product2.setPrice(28.04);
        ptStory.save(product2);
    }

    public List<Product> getProducts(Product product){
       return  ptStory.findByPriceRange(product.getPrice());

    }

}
