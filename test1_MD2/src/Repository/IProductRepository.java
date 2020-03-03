package Repository;

import Model.Product;

import java.util.List;

public interface IProductRepository<E> extends IGeneralRepository<E> {
    List<Product> sortPriceIncresing();
    List<Product> sortPriceDecresing();
}
