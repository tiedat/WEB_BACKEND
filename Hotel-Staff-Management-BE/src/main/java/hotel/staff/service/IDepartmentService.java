package hotel.staff.service;

import hotel.staff.model.Department;

public interface IDepartmentService  {
    Iterable<Department> findAllDepartment();

    void createDepartment(Department department);

    Department findByDepartmentId(Long id);

    void updateDepartment(Department department);

    void deleteDepartment(Long id);

    Iterable<Department> findByDepartmentNameContains(String searchName);



}
