package com.codegym.repository;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {

    ArrayList<Product> listProducts = new ArrayList<>();

    {
        listProducts.add(new Product(1, "Samsung Galaxy S10"));
        listProducts.add(new Product(2, "Iphone X"));
        listProducts.add(new Product(3, "OPPO"));
        listProducts.add(new Product(4, "NOKIA"));
        listProducts.add(new Product(5, "VSMART PRO"));
    }

    @Override
    public List<Product> findAll() {
        return listProducts;
    }

    @Override
    public void add(Product product) {
        listProducts.add(product);
    }
}
