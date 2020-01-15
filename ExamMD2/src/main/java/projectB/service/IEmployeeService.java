package projectB.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projectB.model.Employee;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);
    Employee findById(Long id);
    void save(Employee employee);
    void  remove(Long id);
    Page<Employee> findAllByDepartment(String departmentName, Pageable pageable);
    Page<Employee> findByNameContain(String name, Pageable pageable);

}
