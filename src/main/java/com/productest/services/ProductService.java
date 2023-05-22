package com.productest.services;

import com.productest.entities.DTO.CreateProductReturnDTO;
import com.productest.entities.DTO.RequestProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface ProductService {

    public ResponseEntity<CreateProductReturnDTO> createProduct(RequestProductDTO requestProductDTO);

}
