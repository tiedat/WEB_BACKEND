package Service.impl;

import Model.Product;

import java.util.*;

import Repository.*;

public class ProductServiceImpl implements IProductService {

    ProductRepositoryImpl productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public void update(int id, Product product) {
        productRepository.update(id, product);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public int checkId(int id) {
        return productRepository.checkId(id);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }


    @Override
    public List<Product> sortPriceIncresing() {
        return productRepository.sortPriceIncresing();
    }

    @Override
    public List<Product> sortPriceDecresing() {
        return productRepository.sortPriceDecresing();
    }
}
