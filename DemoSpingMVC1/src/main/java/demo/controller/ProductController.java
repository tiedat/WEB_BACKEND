package demo.controller;

import demo.model.Product;
import demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping("/products")
    public ModelAndView listProduct() {
        List<Product> productList = productService.findAllHaveBusiness();
        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("products",productList);

        return modelAndView;
    }

    @RequestMapping(value = "product-detail/{id}", method = RequestMethod.GET)
    public ModelAndView productDetail(@PathVariable Long id){

        Product product = null;

        ModelAndView modelAndView = new ModelAndView("/product/detail");
        modelAndView.addObject("product", product);
        return modelAndView;
    }
}
