package market.product.repository;

import market.product.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepository extends CrudRepository<Product, Long> {
    Iterable<Product> findAllByNameContains(String name);
}
