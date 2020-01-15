package projectB.service;

import projectB.model.Department;

public interface IDepartmentService {
    Iterable<Department> findAll();
    Department findById(Long id);
    void save(Department department);
    void remove(Long id);
}
