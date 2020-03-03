package hotel.employee.repository;

import hotel.employee.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface IEmployeeRepository extends CrudRepository<Employee, Long>{
    Iterable<Employee> findAllByNameContainsOrCodeStaffContains(String name, String codeStaff);
}
