package market.product.service;

import market.product.model.Product;

public interface IProductService {
    Iterable<Product> findAll();
    Product findById(Long id);
    Iterable<Product> findAllByNameContains(String name);
    void save(Product product);
    void remove(Long id);
}
