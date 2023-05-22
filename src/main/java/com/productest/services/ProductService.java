package com.productest.services;

import com.productest.entities.DTO.RequestProductDTO;
import com.productest.entities.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    //public ResponseEntity<CreateProductReturnDTO> createProduct(RequestProductDTO requestProductDTO);
    public ResponseEntity<Object> createProduct(RequestProductDTO requestProductDTO);

    public ResponseEntity<List<Product>> findAllProducts();

    boolean isRequestProductDtoValid(RequestProductDTO requestProductDTO);

}
