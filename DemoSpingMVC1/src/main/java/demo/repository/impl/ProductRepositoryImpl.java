package demo.repository.impl;

import demo.model.Product;
import demo.repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {

    List<Product> productList = new ArrayList<>();

    {
        productList.add(new Product(1, "Samsung", 300));
        productList.add(new Product(1, "Iphone", 500));
        productList.add(new Product(1, "Nokia", 700));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Product findById(Long id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product findByName(String name) {
        for (Product product: productList) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }
}
