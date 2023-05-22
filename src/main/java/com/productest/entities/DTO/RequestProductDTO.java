package com.productest.entities.DTO;

import com.productest.entities.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter @Setter
public class RequestProductDTO {

    public Product toProduct() throws IllegalArgumentException {
        return new Product(null, this.name, this.description, this.price);
    }

    @NonNull
    String name;

    @NonNull
    String description;

    @NonNull
    Double price;
}
