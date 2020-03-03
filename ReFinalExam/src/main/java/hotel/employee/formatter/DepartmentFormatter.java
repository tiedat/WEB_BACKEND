package hotel.employee.formatter;

import hotel.employee.model.Department;
import hotel.employee.service.IDepartmentService;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class DepartmentFormatter implements Formatter<Department> {
    private IDepartmentService departmentService;

    public DepartmentFormatter(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public Department parse(String text, Locale locale) throws ParseException {
        return departmentService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Department object, Locale locale) {
        return object.getId().toString();
    }
}
