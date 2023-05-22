package com.productest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products/")
public class ProductController {

    @PostMapping
    public void createProduct(@RequestBody Object object) {
        //TODO
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
    public void findAllProducts() {
        //TODO
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
