package hotel.staff.service.impl;

import hotel.staff.model.Department;
import hotel.staff.model.Staff;
import hotel.staff.repository.IStaffRepository;
import hotel.staff.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements IStaffService {

    @Autowired
    private IStaffRepository staffRepository;

    @Override
    public Iterable<Staff> findAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public void createStaff(Staff staff) {
        staffRepository.save(staff);
    }

    @Override
    public Staff findByStaffId(Long id) {
        return staffRepository.findOne(id);
    }

    @Override
    public void updateStaff(Staff staff) {
        staffRepository.save(staff);
    }

    @Override
    public void deleteStaff(Long id) {
        staffRepository.delete(id);
    }

    @Override
    public Iterable<Staff> findAllByStaffNameContains(String searchName) {
        return staffRepository.findByNameContains(searchName);
    }

    @Override
    public Iterable<Staff> findByDepartment(Department department) {
        Iterable<Staff> staffList = staffRepository.findByDepartment(department);
        return staffList;
    }
}
