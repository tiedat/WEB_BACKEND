package projectB.formatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import projectB.model.Department;
import projectB.service.IDepartmentService;

import java.text.ParseException;
import java.util.Locale;

public class DepartmentFormatter implements Formatter<Department> {

    private IDepartmentService departmentService;

    @Autowired
    public DepartmentFormatter(IDepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @Override
    public Department parse(String text, Locale locale) throws ParseException {
        return departmentService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Department object, Locale locale) {
        return "[" + object.getId() + "," + object.getName();
    }


}
