package demo.service.impl;

import demo.model.Product;
import demo.repository.IProductRepository;
import demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements IProductService {

    @Autowired
    IProductRepository productRepository;

    @Override
    public List<Product> findAllHaveBusiness() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id);
    }
}
