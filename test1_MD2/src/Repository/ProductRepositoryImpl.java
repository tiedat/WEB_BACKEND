package Repository;

import Model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository<Product> {

    ArrayList<Product> listProducts = new ArrayList<>();

    {
        //contrutor id, name, price, status, description
        listProducts.add(new Product(1, "OPPO", 10, true, "Camera Phone"));
        listProducts.add(new Product(2, "XIAOMI", 5, true, "Power has a new look"));
        listProducts.add(new Product(3, "IPHONE", 20, false, "Stay hurry, stay foolish"));
        listProducts.add(new Product(4, "SAMSUNG", 12, false, "Do bigger thing"));
        listProducts.add(new Product(5, "HUAWEI", 7, false, "Make it posible"));
    }


    @Override
    public List<Product> findAll() {
        return listProducts;
    }

    @Override
    public void add(Product product) {
        listProducts.add(product);
    }

    @Override
    public void update(int id, Product product) {
        int index = checkId(id);
        listProducts.set(index, product);
    }

    @Override
    public void delete(int id) {
        int index = checkId(id);
        listProducts.remove(index);
    }

    @Override
    public int checkId(int id) {
        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Product findByName(String name) {
        for (Product product : listProducts) {
            if (product.getName().contains(name))
                return product;
        }
        return null;
    }

    @Override
    public List<Product> sortPriceIncresing() {
        Collections.sort(listProducts, Comparator.comparingDouble(Product::getPrice));
        return listProducts;
    }

    @Override
    public List<Product> sortPriceDecresing() {
        Collections.sort(listProducts, Comparator.comparingDouble(Product::getPrice).reversed());
        return listProducts;
    }
}
