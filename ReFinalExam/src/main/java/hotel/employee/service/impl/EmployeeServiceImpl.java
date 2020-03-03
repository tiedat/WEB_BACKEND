package hotel.employee.service.impl;

import hotel.employee.model.Employee;
import hotel.employee.repository.IEmployeeRepository;
import hotel.employee.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepository receptionRepository;

    @Override
    public Iterable<Employee> findAll() {
        return receptionRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return receptionRepository.findOne(id);
    }

    @Override
    public Iterable<Employee> findAllByNameContainsOrCodeStaffContains(String name, String codeStaff) {
        return receptionRepository.findAllByNameContainsOrCodeStaffContains(name, codeStaff);
    }

    @Override
    public void save(Employee employee) {
        receptionRepository.save(employee);
    }

    @Override
    public void remove(Long id) {
        receptionRepository.delete(id);
    }
}
