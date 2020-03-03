package market.product.controller;

import market.product.model.Field;
import market.product.model.Product;
import market.product.service.IFieldService;
import market.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@CrossOrigin("*")
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private IFieldService fieldService;

    @Autowired
    private IProductService productService;

    @ModelAttribute("fields")
    public Iterable<Field> fields() {
        return fieldService.findAll();
    }

    //-------------------------------list-------------------------------------------
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Product>> listAllProduct() {
        Iterable<Product> products = productService.findAll();

        if (products == null) {
            return new ResponseEntity<Iterable<Product>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Iterable<Product>>(products, HttpStatus.OK);
    }

    //-------------------------------findAllByNameContains-------------------------------------------

    @RequestMapping(value = "/findAllByNameContains", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Product>> listAllProduct(@RequestParam("search") String searchText) {
        Iterable<Product> products = productService.findAllByNameContains(searchText);

        if (products == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(products, HttpStatus.OK);

    }

    //-------------------------------create------------------------------------------------------------


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createProduct(@RequestBody Product product,
                                              UriComponentsBuilder uriComponentsBuilder) {

        productService.save(product);

        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.setLocation(uriComponentsBuilder.path("/save/{id}").buildAndExpand(product.getId()).toUri());

        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    //-------------------------------detail------------------------------------------------------------

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> detailProduct(@PathVariable("id") Long id) {

        Product product = productService.findById(id);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    //-------------------------------edit------------------------------------------------------------


    @RequestMapping(value = "/edit/id", method = RequestMethod.PUT)
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {

        productService.save(product);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    //-------------------------------delete------------------------------------------------------------


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id) {

        productService.remove(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
