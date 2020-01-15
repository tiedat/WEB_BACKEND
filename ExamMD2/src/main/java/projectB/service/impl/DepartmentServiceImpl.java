package projectB.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import projectB.model.Department;
import projectB.repository.IDepartmentRepository;
import projectB.service.IDepartmentService;

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

    @Override
    public void save(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void remove(Long id) {
        departmentRepository.delete(id);
    }
}
