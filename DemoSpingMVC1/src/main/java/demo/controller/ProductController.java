package demo.controller;

import demo.model.Product;
import demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import java.util.List;

@Controller
@RequestMapping("product/")
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping("/list")
    public ModelAndView listProduct() {
        List<Product> productList = productService.findAllHaveBusiness();
        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("products", productList);

        return modelAndView;
    }

    @RequestMapping(value = "product-detail/{id}", method = RequestMethod.GET)
    public ModelAndView productDetail(@PathVariable Long id) {
        Product product = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/product/detail");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @RequestMapping(value = "search")
    public ModelAndView searchProduct(@RequestParam("txtSearch") String txtsearch) {
        Product product = productService.findByName(txtsearch);
        ModelAndView modelAndView = new ModelAndView("/product/search");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @RequestMapping(value = "create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @RequestMapping(value = "save-product")
    public ModelAndView saveProduct(@ModelAttribute("product") Product product) {

        productService.save(product);

        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }
}
