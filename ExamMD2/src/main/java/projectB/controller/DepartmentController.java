package projectB.controller;

import com.sun.org.apache.xerces.internal.impl.dv.xs.MonthDV;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import projectB.model.Department;
import projectB.service.IDepartmentService;
import projectB.service.IEmployeeService;

import javax.jws.WebParam;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    @GetMapping("/list")
    public ModelAndView listDepartment() {
        Iterable<Department> departments = departmentService.findAll();
        ModelAndView modelAndView = new ModelAndView("/department/list");
        modelAndView.addObject("departments", departments);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createDepartment() {
        ModelAndView modelAndView = new ModelAndView("/department/create");
        modelAndView.addObject("department", new Department());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveDepartment(@ModelAttribute("department") Department department,
                                       final RedirectAttributes redirectAttributes) {
        if (!department.getName().equals("")) {
            departmentService.save(department);
            ModelAndView modelAndView = new ModelAndView("redirect:/department/list");
            redirectAttributes.addFlashAttribute("message", "New department created successfully");
            return modelAndView;
        } else {
            return new ModelAndView("/error.404");
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Department department = departmentService.findById(id);
        if (department != null) {
            ModelAndView modelAndView = new ModelAndView("/department/edit");
            modelAndView.addObject("department", department);
            return modelAndView;
        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/edit")
    public ModelAndView updateDepartment(@ModelAttribute("department") Department department, final RedirectAttributes redirectAttributes) {
        departmentService.save(department);
        ModelAndView modelAndView = new ModelAndView("redirect:/department/list");
        redirectAttributes.addFlashAttribute("message","Department updated successfully");
        return modelAndView;
    }
//    @PostMapping("/edit")
//    public String addCustomer(@ModelAttribute("department") Department department,
//                              final RedirectAttributes redirectAttributes) {
//
//        departmentService.save(department);
//        redirectAttributes.addFlashAttribute("message","Department updated successfully");
//        return "redirect:/department/list";
//    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Department department = departmentService.findById(id);
        if (department != null) {
            ModelAndView modelAndView = new ModelAndView("/department/delete");
            modelAndView.addObject("department", department);
            return modelAndView;
        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/delete")
    public ModelAndView deleteProvince(@ModelAttribute("department") Department department, final RedirectAttributes redirectAttributes) {
        departmentService.remove(department.getId());
        ModelAndView modelAndView = new ModelAndView("redirect:/department/list");
        redirectAttributes.addFlashAttribute("message", "Delete Successfully");
        return modelAndView;
    }

}
