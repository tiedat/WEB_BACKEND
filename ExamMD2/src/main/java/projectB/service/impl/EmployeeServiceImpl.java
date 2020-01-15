package projectB.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projectB.model.Employee;
import projectB.repository.IEmployeeRepository;
import projectB.service.IEmployeeService;

public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(Long id) {
        employeeRepository.delete(id);
    }

    @Override
    public Page<Employee> findAllByDepartment(String departmentName, Pageable pageable) {
        return employeeRepository.findAllByDepartment(departmentName, pageable);
    }

    @Override
    public Page<Employee> findByNameContain(String name, Pageable pageable) {
        return employeeRepository.findByNameContaining(name, pageable);
    }
}
