package com.productest.productest.services;

import com.productest.entities.DTO.RequestProductDTO;
import com.productest.repositories.ProductRepository;
import com.productest.services.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTests {

    @Mock
    ProductRepository productRepository;

    ProductServiceImpl subject;

    @BeforeEach
    void setUp() {
        subject = new ProductServiceImpl(productRepository);
    }

    @Test
    public void shouldNotReturnOk_InvalidParams() {
        assertFalse(subject.isRequestProductDtoValid(invalidRequestProductDto()));
        assertFalse(subject.isRequestProductDtoValid(invalidNegativePriceRequestProductDto()));
        assertFalse(subject.isRequestProductDtoValid(invalidNameRequestProductDto()));
        assertFalse(subject.isRequestProductDtoValid(invalidDescriptionRequestProductDto()));
        assertFalse(subject.isRequestProductDtoValid(invalidPriceRequestProductDto()));
        assertFalse(subject.isRequestProductDtoValid(invalidNameAndPriceRequestProductDto()));
        assertFalse(subject.isRequestProductDtoValid(invalidDescriptionAndNameRequestProductDto()));
        assertFalse(subject.isRequestProductDtoValid(invalidDescriptionAndPriceRequestProductDto()));
    }

    @Test
    public void shouldBeOk_ValidParams() {
        assertTrue(subject.isRequestProductDtoValid(validRequestProductDto()));
    }

    private RequestProductDTO validRequestProductDto() {
        var dto = new RequestProductDTO();
        dto.setName("Foo");
        dto.setDescription("Bar");
        dto.setPrice(1000.00);
        return dto;
    }

    private RequestProductDTO invalidNegativePriceRequestProductDto() {
        var dto = new RequestProductDTO();
        dto.setName("Foo");
        dto.setDescription("Bar");
        dto.setPrice(-1000.00);
        return dto;
    }

    private RequestProductDTO invalidRequestProductDto() {
        var dto = new RequestProductDTO();
        return dto;
    }

    private RequestProductDTO invalidPriceRequestProductDto() {
        var dto = new RequestProductDTO();
        dto.setName("Foo");
        dto.setDescription("Bar");
        return dto;
    }

    private RequestProductDTO invalidNameRequestProductDto() {
        var dto = new RequestProductDTO();
        dto.setPrice(1000.00);
        dto.setDescription("Bar");
        return dto;
    }

    private RequestProductDTO invalidDescriptionRequestProductDto() {
        var dto = new RequestProductDTO();
        dto.setName("Foo");
        dto.setPrice(1000.00);
        return dto;
    }

    private RequestProductDTO invalidNameAndPriceRequestProductDto() {
        var dto = new RequestProductDTO();
        dto.setDescription("Bar");
        return dto;
    }

    private RequestProductDTO invalidDescriptionAndNameRequestProductDto() {
        var dto = new RequestProductDTO();
        dto.setPrice(1000.00);
        return dto;
    }

    private RequestProductDTO invalidDescriptionAndPriceRequestProductDto() {
        var dto = new RequestProductDTO();
        dto.setName("Foo");
        return dto;
    }

}
