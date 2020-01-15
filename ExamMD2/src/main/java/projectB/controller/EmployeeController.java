package projectB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import projectB.model.Department;
import projectB.model.Employee;
import projectB.model.EmployeeForm;
import projectB.service.IDepartmentService;
import projectB.service.IEmployeeService;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IDepartmentService departmentService;

    @Autowired
    Environment env;

    @ModelAttribute("departments")
    public Iterable<Department> departments() {
        return departmentService.findAll();
    }


    @GetMapping("/list")
    public ModelAndView listEmployees(@RequestParam("departmentName") Optional<String> name, @PageableDefault(value = 2, sort = "salary") Pageable pageable) {
        Page<Employee> employees;
        if (name.isPresent()) {
            employees = employeeService.findAllByDepartment(name.get(), pageable);

        } else {
            employees = employeeService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employeeForm", new EmployeeForm());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveEmployee(@Validated @ModelAttribute("employeeForm") EmployeeForm employeeForm,
                                     final RedirectAttributes redirectAttributes,
                                     BindingResult result) {

        if (result.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("/employee/create");
            modelAndView.addObject("employeeForm", new EmployeeForm());
            modelAndView.addObject("message", "\n" +
                    "Wrong data type of field birthDate !!!");
            return modelAndView;
        }

        String fileName = configUploadFile(employeeForm);

        Employee employee = new Employee(employeeForm.getName(), employeeForm.getDob(),
                employeeForm.getAddress(), fileName, employeeForm.getSalary(), employeeForm.getDepartment());

        employeeService.save(employee);

        ModelAndView modelAndView = new ModelAndView("redirect:/employee/list");
        redirectAttributes.addFlashAttribute("message", "Employee create successfully !!!");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Employee employee = employeeService.findById(id);
        if (employee != null) {
            ModelAndView modelAndView = new ModelAndView("/employee/edit");
            modelAndView.addObject("employeeForm", employee);
            return modelAndView;
        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/edit")
    public ModelAndView updateEmployee(@ModelAttribute("employeeForm") EmployeeForm employeeForm,
                                       final RedirectAttributes redirectAttributes,
                                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("/employee/edit");
            modelAndView.addObject("employeeForm", new EmployeeForm());
            modelAndView.addObject("message", "\n" +
                    "Wrong data type of field birthDate !!!");
            return modelAndView;
        }

        String fileName = configUploadFile(employeeForm);

        Employee employee = employeeService.findById(employeeForm.getId());

        employee.setName(employeeForm.getName());
        employee.setDepartment(employeeForm.getDepartment());
        employee.setAvatar(fileName);
        employee.setSalary(employeeForm.getSalary());
        employee.setAddress(employeeForm.getAddress());
        employee.setDob(employeeForm.getDob());

        employeeService.save(employee);
        
        ModelAndView modelAndView = new ModelAndView("redirect:/employee/list");
        redirectAttributes.addFlashAttribute("message", "Employee updated successfully");
        return modelAndView;
    }

    private String configUploadFile(EmployeeForm employeeForm) {

        MultipartFile multipartFile = employeeForm.getAvatar();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("file_upload");

        try {
            FileCopyUtils.copy(employeeForm.getAvatar().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return fileName;
    }
}
