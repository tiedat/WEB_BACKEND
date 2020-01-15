package market.product.formatter;

import market.product.model.Field;
import market.product.service.IFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class FieldFormatter implements Formatter<Field> {

    private IFieldService fieldService;

    public FieldFormatter(IFieldService fieldService){
        this.fieldService = fieldService;
    }

    @Override
    public Field parse(String text, Locale locale) throws ParseException {
        return fieldService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Field object, Locale locale) {
        return object.getId().toString();
    }


}
