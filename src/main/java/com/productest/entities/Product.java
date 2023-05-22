package com.productest.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column
    @NonNull
    private String name;

    @Column
    @NonNull
    private String description;

    @Column
    @NonNull
    private Double price;

}
