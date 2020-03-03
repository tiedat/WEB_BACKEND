package hotel.employee.controller;

import hotel.employee.model.Department;
import hotel.employee.model.Employee;
import hotel.employee.service.IDepartmentService;
import hotel.employee.service.IEmployeeService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    IDepartmentService departmentService;

    @ModelAttribute("departments")
    public Iterable<Department> departments() {
        return departmentService.findAll();
    }

    @GetMapping("/list")
    public ModelAndView listProduct(@RequestParam("s") Optional<String> s) {
        Iterable<Employee> employees;
        if (s.isPresent()) {
            employees = employeeService.findAllByNameContainsOrCodeStaffContains(s.get(), s.get());
        } else {
            employees = employeeService.findAll();
        }
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        modelAndView.addObject("employees", employees);
        modelAndView.addObject("message");
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Employee employee = employeeService.findById(id);
        if (employee != null) {
            ModelAndView modelAndView = new ModelAndView("/employee/edit");
            modelAndView.addObject("employee", employee);
            return modelAndView;

        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/save")
    public ModelAndView saveProduct(@Valid @ModelAttribute("employee") Employee employee,
                                    BindingResult result,
                                    final RedirectAttributes redirectAttributes) {

        new Employee().validate(employee, result);

        if (result.hasFieldErrors()) {
            if (employee.getId() == null) {
                return new ModelAndView("/employee/create");
            } else {
                return new ModelAndView("/employee/edit");
            }
        }

        ModelAndView modelAndView = new ModelAndView("redirect:/list");

        if (employee.getId() == null) {
            redirectAttributes.addFlashAttribute("message",
                    "Created successfully");
        } else {
            redirectAttributes.addFlashAttribute("message",
                    "Edited successfully");
        }

        employeeService.save(employee);
        return modelAndView;
    }

//    @PostMapping("/create")
//    public ModelAndView create(@Valid @ModelAttribute("employee") Employee employee,
//                                    BindingResult result,
//                                    final RedirectAttributes redirectAttributes) {
//
//        new Employee().validate(employee, result);
//
//        if (result.hasFieldErrors()) {
//            ModelAndView modelAndView = new ModelAndView("/employee/create");
//            return modelAndView;
//        }
//
//        ModelAndView modelAndView = new ModelAndView("redirect:/list");
//        redirectAttributes.addFlashAttribute("message",
//                "Created successfully");
//
//        employeeService.save(employee);
//        return modelAndView;
//    }

//    @PostMapping("/edit")
//    public ModelAndView edit(@Valid @ModelAttribute("employee") Employee employee,
//                                    BindingResult result,
//                                    final RedirectAttributes redirectAttributes) {
//
//        new Employee().validate(employee, result);
//
//        if (result.hasFieldErrors()) {
//            ModelAndView modelAndView = new ModelAndView("/employee/edit");
//                return modelAndView;
//            }
//
//        ModelAndView modelAndView = new ModelAndView("redirect:/list");
//            redirectAttributes.addFlashAttribute("message",
//                    "Edited successfully");
//        employeeService.save(employee);
//        return modelAndView;
//    }


    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Employee employee = employeeService.findById(id);
        if (employee != null) {
            ModelAndView modelAndView = new ModelAndView("/employee/delete");
            modelAndView.addObject("employee", employee);
            return modelAndView;
        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deleteProduct(@PathVariable Long id, @NotNull final RedirectAttributes redirectAttributes) {
        employeeService.remove(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/list");
        redirectAttributes.addFlashAttribute("message", "deleted successfully");
        return modelAndView;
    }
}
