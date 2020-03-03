package hotel.employee.service;


import hotel.employee.model.Employee;

public interface IEmployeeService {
    Iterable<Employee> findAll();
    Employee findById(Long id);
    Iterable<Employee> findAllByNameContainsOrCodeStaffContains(String name, String codeStaff);
    void save(Employee employee);
    void remove(Long id);
}
