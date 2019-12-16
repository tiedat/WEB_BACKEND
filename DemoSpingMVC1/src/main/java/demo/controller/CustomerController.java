package demo.controller;

import demo.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {

    @RequestMapping(value = "list", method = RequestMethod.GET)
    List<Product> productList = productService.findAllHaveBusiness();
    ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("message","Danh sach khach hang");

        return modelAndView;
}
