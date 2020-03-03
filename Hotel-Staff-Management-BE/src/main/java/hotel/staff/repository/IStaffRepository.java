package hotel.staff.repository;

import hotel.staff.model.Department;
import hotel.staff.model.Staff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStaffRepository extends CrudRepository<Staff, Long> {
    Iterable<Staff> findByNameContains(String searchName);

    Iterable<Staff> findByDepartment(Department department);

}
