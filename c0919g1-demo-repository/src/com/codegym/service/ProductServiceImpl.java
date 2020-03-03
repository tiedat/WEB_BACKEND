package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements IProductService{

    ProductRepositoryImpl productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAllHaveBusiness() {
        // code business
        return productRepository.findAll();
    }

    @Override
    public void addHaveBusiness(Product product) {
        //code business
        productRepository.add(product);
    }
}
