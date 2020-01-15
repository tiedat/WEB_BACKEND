package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.PublicKey;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    IProductService productService;

    @RequestMapping("/products")
    public ModelAndView getAllProduct() {

        List<Product> products = productService.findAll();
        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("products", products);

        return modelAndView;
    }

    @RequestMapping("/add")
    public ModelAndView addProduct() {

        //add Product to database
        Product product = new Product("Samsung", 900d);
        productService.add(product);

        ModelAndView modelAndView = new ModelAndView("/product/list");
        return modelAndView;
    }

    @RequestMapping("/findbyid")
    public ModelAndView findById() {

        Product product = productService.findById(Long.parseLong("3"));

        ModelAndView modelAndView = new ModelAndView("/product/list");
        return modelAndView;
    }
}
