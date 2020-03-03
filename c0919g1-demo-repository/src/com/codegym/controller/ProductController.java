package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductServiceImpl;

import java.util.List;

public class ProductController {
    ProductServiceImpl productService = new ProductServiceImpl();

    public List<Product> getProducts() {
        return productService.findAllHaveBusiness();
    }

    public void addProduct(Product product) {
        productService.addHaveBusiness(product);
    }
}
