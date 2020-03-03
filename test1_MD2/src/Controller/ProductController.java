package Controller;

import Model.Product;
import Service.impl.ProductServiceImpl;

import java.util.List;

public class ProductController {
    ProductServiceImpl productService = new ProductServiceImpl();

    public List<Product> findAll() {
        return productService.findAll();
    }
    public void add(Product product) {
        productService.add(product);
    }

    public void update(int id, Product product) {
        productService.update(id, product);
    }

    public void delete(int id) {
        productService.delete(id);
    }

    public int checkId(int id) {
        return productService.checkId(id);
    }

    public Product findByName(String name) {
        return productService.findByName(name);
    }

    public List<Product> sortPriceIncresing() {
        return productService.sortPriceIncresing();
    }

    public List<Product> sortPriceDecresing() {
        return productService.sortPriceDecresing();
    }


}
