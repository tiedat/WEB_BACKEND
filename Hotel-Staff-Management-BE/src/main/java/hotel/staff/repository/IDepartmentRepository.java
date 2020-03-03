package hotel.staff.repository;

import hotel.staff.model.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepartmentRepository extends CrudRepository<Department, Long> {
    Iterable<Department> findByNameContains(String searchName);
}
