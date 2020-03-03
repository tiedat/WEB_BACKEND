package hotel.staff.controller;

import hotel.staff.model.Department;
import hotel.staff.model.Staff;
import hotel.staff.service.IDepartmentService;
import hotel.staff.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/staffs")
public class StaffController {

    @Autowired
    private IStaffService staffService;

    @Autowired
    private IDepartmentService departmentService;

    @GetMapping
    public ResponseEntity<Iterable<Staff>> getListStaff() {
        Iterable<Staff> departments = staffService.findAllStaff();
        if (departments == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Void> createStaff(@RequestBody Staff department) {
        try {
            staffService.createStaff(department);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Staff> getStaff(@PathVariable("id") Long id) {
        try {
            Staff department = staffService.findByStaffId(id);
            return new ResponseEntity<>(department, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<Void> updateStaff(@RequestBody Staff department) {
        try {
            staffService.updateStaff(department);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStaff(@PathVariable("id") Long id) {
        try {
            staffService.deleteStaff(id);
            return new ResponseEntity<>((HttpStatus.OK));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/find")
    public ResponseEntity<Iterable<Staff>> findStaff(@RequestParam String staffName) {
        Iterable<Staff> departments = staffService.findAllByStaffNameContains(staffName);
        if (departments == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping("/dep/{dep}")
    public ResponseEntity<Iterable<Staff>> getListStaffByDepartment(@PathVariable("dep") Department department) {
        try {
            Iterable<Staff> staffs = staffService.findByDepartment(department);
            return new ResponseEntity<>(staffs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
