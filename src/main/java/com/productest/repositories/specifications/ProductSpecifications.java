package com.productest.repositories.specifications;

import com.productest.entities.Product;
import com.productest.entities.metamodel.Product_;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecifications {

    public static Specification<Product> productNameIs(String param) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Product_.name), param);
    }

    public static Specification<Product> productDescriptionIs(String param) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Product_.description), param);
    }

    public static Specification<Product> productPriceIsGreaterThan(Double lower) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(Product_.price), lower);
    }

    public static Specification<Product> productPriceIsLesserThan(Double higher) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(Product_.price), higher);
    }

    public static Specification<Product> productPriceIsBetween(Double lower, Double higher) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get(Product_.price), lower, higher);
    }

}
