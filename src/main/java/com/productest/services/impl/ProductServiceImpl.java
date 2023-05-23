package com.productest.services.impl;

import com.productest.entities.DTO.RequestFilterDTO;
import com.productest.entities.DTO.RequestProductDTO;
import com.productest.entities.Product;
import com.productest.repositories.ProductRepository;
import com.productest.services.ProductService;
import lombok.NonNull;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static com.productest.repositories.specifications.ProductSpecifications.*;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<Object> createProduct(RequestProductDTO request) {
        if(isRequestProductDtoValid(request)) {
            return responseBadRequest();
        } else {
            var response = repository.save(request.toProduct());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<Object> updateProduct(String id, RequestProductDTO request) {
        if(!isRequestProductDtoValid(request))
            return responseBadRequest();

        var updateObject = request.toProduct();
        try {
            if (repository.existsById(id)) {
                updateObject.setId(id);
                var response = repository.save(updateObject);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (Exception ignored) {
        }
        return responseNotFound();
    }

    @Override
    public ResponseEntity<Object> findProductById(String id) {
        var response = repository.findById(id);
        return response.<ResponseEntity<Object>>map(product ->
                new ResponseEntity<>(product, HttpStatus.OK))
                .orElseGet(this::responseNotFound);
    }

    @Override
    public ResponseEntity<List<Product>> findAllProducts() {
        var productList = repository.findAll();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Product>> findFilteredProducts(RequestFilterDTO request) {
        if(!isRequestFilterFilled(request))
            return findAllProducts();

        return new ResponseEntity<>(repository.findAll(specificationBuilder(request)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> deleteProduct(String id) {
        var product = repository.findById(id);
        if(product.isPresent()) {
            repository.delete(product.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return responseNotFound();
    }

    public boolean isRequestProductDtoValid(@NonNull RequestProductDTO request) {
        return Stream.of(
                        request.getName(),
                        request.getDescription(),
                        request.getPrice())
                .noneMatch(Objects::isNull)
                && request.getPrice() >= 0.0000;
    }

    public ResponseEntity<Object> responseNotFound() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Object> responseBadRequest() {
        String INVALID_PARAM = "Os valores informados estão incompletos e/ou são inválidos";
        return new ResponseEntity<>(INVALID_PARAM, HttpStatus.BAD_REQUEST);
    }

    public Specification<Product> specificationBuilder(RequestFilterDTO request) {
        List<Specification<Product>> specificationList = new ArrayList<>();

        if ((request.getQ() != null) && (!request.getQ().trim().isEmpty()))
            specificationList.add(productNameIs(request.getQ()).or(productDescriptionIs(request.getQ())));
        if (request.getMinPrice() != null && request.getMaxPrice() != null) {
            specificationList.add(productPriceIsBetween(request.getMinPrice(), request.getMaxPrice()));
        }
        if (request.getMinPrice() != null && request.getMaxPrice() == null)
            specificationList.add(productPriceIsGreaterThan(request.getMinPrice()));
        if (request.getMaxPrice() != null && request.getMinPrice() == null)
            specificationList.add(productPriceIsLesserThan(request.getMaxPrice()));

        Specification<Product> specification = specificationList.get(0);
        for (Specification<Product> productSpecification : specificationList) {
            if (!productSpecification.equals(specificationList.get(0)))
                specification = specification.and(productSpecification);
        }
        return specification;
    }

    public boolean isRequestFilterFilled(@NonNull RequestFilterDTO request) {
        return !Stream.of(request.getMinPrice(), request.getMaxPrice()).allMatch(Objects::isNull)
                || (request.getQ() != null && !request.getQ().trim().isEmpty());
    }

}
