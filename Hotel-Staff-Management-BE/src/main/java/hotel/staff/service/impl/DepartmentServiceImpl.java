package hotel.staff.service.impl;

import hotel.staff.model.Department;
import hotel.staff.repository.IDepartmentRepository;
import hotel.staff.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private IDepartmentRepository departmentRepository;

    @Override
    public Iterable<Department> findAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public void createDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public Department findByDepartmentId(Long id) {
        return departmentRepository.findOne(id);
    }

    @Override
    public void updateDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.delete(id);
    }

    @Override
    public Iterable<Department> findByDepartmentNameContains(String searchName) {
        return departmentRepository.findByNameContains(searchName);
    }
}
