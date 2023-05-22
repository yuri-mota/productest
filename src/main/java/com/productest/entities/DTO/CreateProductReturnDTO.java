package com.productest.entities.DTO;

import lombok.Data;

@Data
public class CreateProductReturnDTO {

    String id;
    String name;
    String desciption;
    Double price;

}
