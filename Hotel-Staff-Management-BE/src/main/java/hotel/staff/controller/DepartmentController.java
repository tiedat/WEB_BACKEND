package hotel.staff.controller;

import hotel.staff.model.Department;
import hotel.staff.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/departments")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    @GetMapping
    public ResponseEntity<Iterable<Department>> getListDepartment() {
        Iterable<Department> departments = departmentService.findAllDepartment();
        if (departments == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Void> createDepartment(@RequestBody Department department) {
        try {
            departmentService.createDepartment(department);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable("id") Long id) {

        try {
            Department department = departmentService.findByDepartmentId(id);
            return new ResponseEntity<>(department, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<Void> updateDepartment(@RequestBody Department department) {
        try {
            departmentService.updateDepartment(department);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{{id}}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable("{id}") String parameter) {
        try {
            Long id = Long.parseLong(parameter);
            departmentService.deleteDepartment(id);
            return new ResponseEntity<>((HttpStatus.OK));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/find")
    public ResponseEntity<Iterable<Department>> findDepartmentByName(@RequestParam("name") String departmentName) {
        Iterable<Department> departments = departmentService.findByDepartmentNameContains(departmentName);
        if (departments == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(departments, HttpStatus.OK);

    }
}
