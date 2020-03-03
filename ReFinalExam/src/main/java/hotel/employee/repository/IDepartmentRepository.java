package hotel.employee.repository;

import hotel.employee.model.Department;
import org.springframework.data.repository.CrudRepository;

public interface IDepartmentRepository extends CrudRepository<Department, Long> {
}
