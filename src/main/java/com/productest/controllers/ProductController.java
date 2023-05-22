package com.productest.controllers;

import com.productest.entities.DTO.CreateProductReturnDTO;
import com.productest.entities.DTO.RequestProductDTO;
import com.productest.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "products/", produces = "application/json")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<CreateProductReturnDTO> createProduct(@RequestBody RequestProductDTO requestProductDTO) {
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
