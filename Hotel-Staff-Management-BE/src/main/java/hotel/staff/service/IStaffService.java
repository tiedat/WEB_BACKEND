package hotel.staff.service;

import hotel.staff.model.Department;
import hotel.staff.model.Staff;

public interface IStaffService {
    Iterable<Staff> findAllStaff();

    void  createStaff(Staff staff);

    Staff findByStaffId(Long id);

    void updateStaff(Staff staff);

    void deleteStaff(Long id);

    Iterable<Staff> findAllByStaffNameContains(String searchName);

    Iterable<Staff> findByDepartment(Department department);


}
