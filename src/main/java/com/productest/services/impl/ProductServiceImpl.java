package com.productest.services.impl;

import com.productest.entities.DTO.RequestProductDTO;
import com.productest.entities.Product;
import com.productest.repositories.ProductRepository;
import com.productest.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final String PARAMETROS_DE_ENTRADA_INVALIDOS = "Os valores informados estão incompletos e/ou são inválidos";

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<Object> createProduct(RequestProductDTO requestProductDTO) {
        if(isRequestProductDtoValid(requestProductDTO)) {
            return new ResponseEntity<>(PARAMETROS_DE_ENTRADA_INVALIDOS, HttpStatus.BAD_REQUEST);
        } else {
            var responseBody = productRepository.save(requestProductDTO.toProduct());
            return new ResponseEntity<>(responseBody, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<List<Product>> findAllProducts() {
        var productList = productRepository.findAll();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    public boolean isRequestProductDtoValid(RequestProductDTO requestProductDTO) {
        return !Stream.of(
                        requestProductDTO.getName(),
                        requestProductDTO.getDescription(),
                        requestProductDTO.getPrice())
                .anyMatch(Objects::isNull);
    }
}
