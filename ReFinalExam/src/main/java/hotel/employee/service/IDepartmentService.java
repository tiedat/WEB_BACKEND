package hotel.employee.service;

import hotel.employee.model.Department;

public interface IDepartmentService {
    Iterable<Department> findAll();

    Department findById(Long id);
}
