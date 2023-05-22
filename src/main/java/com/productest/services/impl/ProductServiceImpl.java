package com.productest.services.impl;

import com.productest.entities.DTO.CreateProductReturnDTO;
import com.productest.entities.DTO.RequestProductDTO;
import com.productest.entities.Product;
import com.productest.repositories.ProductRepository;
import com.productest.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<CreateProductReturnDTO> createProduct(RequestProductDTO requestProductDTO) {
        ResponseEntity<CreateProductReturnDTO> response;
        try {
            Product responseProduct = productRepository.save(requestProductDTO.toProduct());
        } catch(Exception exception) {

        };
        return null;
    }
}
