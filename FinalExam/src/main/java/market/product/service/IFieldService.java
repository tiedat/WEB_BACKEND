package market.product.service;

import market.product.model.Field;

public interface IFieldService {
    Iterable<Field> findAll();

    Field findById(long id);
}
