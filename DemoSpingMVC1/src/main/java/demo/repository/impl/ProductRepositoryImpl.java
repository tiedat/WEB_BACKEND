package demo.repository.impl;

import demo.model.Product;
import demo.repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {

    List<Product> productList = new ArrayList<>();
    {
        productList.add(new Product(1,"Samsung", 300));
        productList.add(new Product(1,"Iphone", 500));
        productList.add(new Product(1,"Nokia", 700));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }
}
