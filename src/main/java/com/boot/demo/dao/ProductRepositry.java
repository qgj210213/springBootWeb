package com.boot.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.boot.demo.persistBean.Product;

public interface ProductRepositry extends JpaRepository<Product, Integer> {
    //通过商品价格范围查询商品
    @Query(value = "select p.* from db_product p where p.price >=?1", nativeQuery = true)
    @Modifying
    public List<Product> findByPriceRange(Double price);

}
