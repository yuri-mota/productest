package com.productest.entities.DTO;

import com.productest.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestProductDTO {

    public Product toProduct() {
        return new Product(null, this.name, this.description, this.price);
    }
    String name;
    String description;
    Double price;

}
