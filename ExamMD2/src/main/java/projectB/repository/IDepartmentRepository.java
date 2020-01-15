package projectB.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import projectB.model.Department;

public interface IDepartmentRepository extends PagingAndSortingRepository<Department, Long> {

}
