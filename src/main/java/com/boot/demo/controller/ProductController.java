package com.boot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.demo.persistBean.Product;
import com.boot.demo.services.ProductService;

@RestController
@RequestMapping(value = "pt")
public class ProductController {
    @Autowired
    ProductService productService;

    /**
     * @return
     * 追加商品信息
     */
    @RequestMapping(value = "/add")
    private String addProduct() {
        productService.addProduct();
        return "ok";
    }

    /**
     * @param product
     * 通过价格范围查询商品
     * @return
     */
    @PostMapping(value="/searchByPrice")
    private Object getProdutList(@ModelAttribute(value="product") Product product) {
        return productService.getProducts(product);

    }

}
