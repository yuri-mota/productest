package com.productest.entities.DTO;

import com.productest.entities.Product;
import lombok.Data;

@Data
public class CreateProductReturnDTO {

    public CreateProductReturnDTO(Product product) {
        this.setId(product.getId());
        this.setName(product.getName());
        this.setDesciption(product.getDescription());
        this.setPrice(product.getPrice());
    }

    String id;
    String name;
    String desciption;
    Double price;

}
