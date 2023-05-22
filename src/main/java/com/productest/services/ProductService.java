package com.productest.services;

import com.productest.entities.DTO.RequestProductDTO;
import com.productest.entities.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    //public ResponseEntity<CreateProductReturnDTO> createProduct(RequestProductDTO requestProductDTO);
    ResponseEntity<Object> createProduct(RequestProductDTO request);

    ResponseEntity<Object> updateProduct(String id, RequestProductDTO request);

    ResponseEntity<List<Product>> findAllProducts();

    boolean isRequestProductDtoValid(RequestProductDTO request);

}
