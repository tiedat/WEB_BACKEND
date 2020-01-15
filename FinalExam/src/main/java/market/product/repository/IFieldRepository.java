package market.product.repository;

import market.product.model.Field;
import org.springframework.data.repository.CrudRepository;

public interface IFieldRepository extends CrudRepository<Field, Long> {
}
