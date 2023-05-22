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

    private final ProductRepository repository;

    private final String PARAMETROS_DE_ENTRADA_INVALIDOS = "Os valores informados estão incompletos e/ou são inválidos";

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<Object> createProduct(RequestProductDTO request) {
        if(isRequestProductDtoValid(request)) {
            return new ResponseEntity<>(PARAMETROS_DE_ENTRADA_INVALIDOS, HttpStatus.BAD_REQUEST);
        } else {
            var responseBody = repository.save(request.toProduct());
            return new ResponseEntity<>(responseBody, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<Object> updateProduct(String id, RequestProductDTO request) {
        if(!isRequestProductDtoValid(request))
            return new ResponseEntity<>(PARAMETROS_DE_ENTRADA_INVALIDOS, HttpStatus.BAD_REQUEST);

        var updateObject = request.toProduct();
        try {
            if (repository.existsById(id)) {
                updateObject.setId(id);
                var response = repository.save(updateObject);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (Exception exception){}
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> findProductById(String id) {
        //TODO
        return null;
    }

    @Override
    public ResponseEntity<List<Product>> findAllProducts() {
        var productList = repository.findAll();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Product>> findFilteredProducts() {
        //TODO
        return null;
    }

    @Override
    public ResponseEntity<Object> deleteProduct(String id) {
        //TODO
        return null;
    }

    public boolean isRequestProductDtoValid(RequestProductDTO request) {
        return !Stream.of(
                        request.getName(),
                        request.getDescription(),
                        request.getPrice())
                .anyMatch(Objects::isNull);
    }
}
