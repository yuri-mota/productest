package com.productest.entities.DTO;

import com.productest.entities.Product;

public class RequestProductDTO {

    public Product toProduct() throws IllegalArgumentException {

        return new Product(null, this.name, this.description, this.price);
    }

    String name;
    String description;
    Double price;
}
