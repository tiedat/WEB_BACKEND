package demo.repository.impl;

import demo.model.Product;
import demo.repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {

    List<Product> productList = new ArrayList<>();

    {
        productList.add(new Product(1, "Samsung", 300, "img1"));
        productList.add(new Product(2, "Iphone", 500, "img2"));
        productList.add(new Product(3, "Nokia", 700, "img3"));
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
