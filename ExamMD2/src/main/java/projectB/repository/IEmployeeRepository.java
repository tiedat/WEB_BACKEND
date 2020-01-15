package projectB.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import projectB.model.Employee;

public interface IEmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
    Page<Employee> findAllByDepartment(String departmentName, Pageable pageable);
    Page<Employee> findByNameContaining(String name, Pageable pageable);
}
