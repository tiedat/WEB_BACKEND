package market.product.service.impl;

import market.product.model.Field;
import market.product.repository.IFieldRepository;
import market.product.service.IFieldService;
import org.springframework.beans.factory.annotation.Autowired;

public class FieldServiceImpl implements IFieldService {

    @Autowired
    private IFieldRepository fieldRepository;

    @Override
    public Field findById(long id) {
        return fieldRepository.findOne(id);
    }

    @Override
    public Iterable<Field> findAll() {
        return fieldRepository.findAll();
    }
}
