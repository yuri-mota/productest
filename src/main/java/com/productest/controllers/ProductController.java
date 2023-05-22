package com.productest.controllers;

import com.productest.entities.DTO.RequestProductDTO;
import com.productest.entities.Product;
import com.productest.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "products/", produces = "application/json")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Object> createProduct(@RequestBody RequestProductDTO requestProductDTO) {
        return productService.createProduct(requestProductDTO);
    }

    @PutMapping(path = "{id}")
    public void updateProduct(@PathVariable String id, @RequestBody Object object) {
        //TODO
    }

    @GetMapping(path = "{id}")
    public void findProductById(@PathVariable String id) {
        //TODO
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts() {
        return productService.findAllProducts();
    }

    @GetMapping(path = "search")
    public void findMatchingPrducts(@RequestBody Object object) {
        //TODO
    }

    @DeleteMapping(path = "{id}")
    public void deleteProduct(@PathVariable String id) {
        //TODO
    }

}
