package market.product.controller;

import market.product.model.Field;
import market.product.model.Product;
import market.product.service.IFieldService;
import market.product.service.IProductService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IFieldService fieldService;

    @Autowired
    private IProductService productService;

    @ModelAttribute("fields")
    public Iterable<Field> fields() {
        return fieldService.findAll();
    }

    @GetMapping("/list")
    public ModelAndView listEmployees(@RequestParam("name") Optional<String> name) {
        Iterable<Product> products;
        if (name.isPresent()) {
            products = productService.findAllByNameContains(name.get());
        } else {
            products = productService.findAll();
        }
        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("products", products);
        modelAndView.addObject("message");
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createDepartment() {
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveDepartment(@ModelAttribute("product") Product product,
                                       BindingResult result) {
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("department", new Product());
        modelAndView.addObject("message", "New department created successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Product product = productService.findById(id);
        if (product != null) {
            ModelAndView modelAndView = new ModelAndView("/product/delete");
            modelAndView.addObject("product", product);
            return modelAndView;
        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/delete")
    public ModelAndView deleteProduct(@NotNull @ModelAttribute("product") Product product, @NotNull final RedirectAttributes redirectAttributes) {
        productService.remove(product.getId());
        ModelAndView modelAndView = new ModelAndView("redirect:/product/list");
        redirectAttributes.addFlashAttribute("message","deleted");
        return modelAndView;
    }

}
