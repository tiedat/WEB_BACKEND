package hotel.employee.service.impl;

import hotel.employee.model.Department;
import hotel.employee.repository.IDepartmentRepository;
import hotel.employee.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;

public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private IDepartmentRepository departmentRepository;

    @Override
    public Iterable<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById(Long id) {
        return departmentRepository.findOne(id);
    }
}
