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

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Object> createProduct(@RequestBody RequestProductDTO request) {
        return service.createProduct(request);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable String id, @RequestBody RequestProductDTO request) {
        return service.updateProduct(id, request);
    }

    @GetMapping(path = "{id}")
    public void findProductById(@PathVariable String id) {
        //TODO
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts() {
        return service.findAllProducts();
    }

    @GetMapping(path = "search")
    public void findMatchingProducts(@RequestBody Object object) {
        //TODO
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable String id) {
        return service.deleteProduct(id);
    }

}
