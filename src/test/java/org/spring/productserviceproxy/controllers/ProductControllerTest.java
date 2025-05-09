package org.spring.productserviceproxy.controllers;

import org.spring.productserviceproxy.clients.fakestore.client.FakeStoreClient;
import org.spring.productserviceproxy.models.Product;
import org.spring.productserviceproxy.services.FakeStoreProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.*;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    @Mock
    RestTemplateBuilder restTemplatebuilder;

    @Autowired
    @Mock
    FakeStoreClient fakeStoreClient;


    @Mock
    FakeStoreProductService productService;

    @Autowired
    ProductController productController;

    @Captor
    private ArgumentCaptor<Long> idCaptor;

    //@Test
    void test_whenGetProductIsCalled_ReturnProducts() {
        Product product = new Product();
        product.setId(2l);
        product.setTitle("test");
        when(productService.getSingleProduct(any(Long.class))).thenReturn(product);

        ResponseEntity<Product> productResponseEntity = productController.getSingleProduct(2l);

        assertNotNull(productResponseEntity);
        assertEquals("test", productResponseEntity.getBody().getTitle());
    }

    //@Test
    void test_whenGetProductIsCalled_ReturnException() {
        // RULE
        when(productService.getSingleProduct(any(Long.class)))
                .thenThrow(new RuntimeException("Something is wrong"));

        assertThrows(RuntimeException.class,
                () -> productController.getSingleProduct(2l));
    }

    @Test
    void test_productControllerCallsProdcutServiceWithSameId() {
        Long id = 2l;
        when(productService.getSingleProduct(id)).thenCallRealMethod();

        productController.getSingleProduct(id);

        verify(productService).getSingleProduct(idCaptor.capture());
        verify(productService, times(1)).getSingleProduct(any());

        assertEquals(id, idCaptor.getValue());
    }

    @Test
    void test_productControllerCallsProdcutServiceWithSameId2() {
        Long id = 2l;
        when(productService.getSingleProduct(id)).thenCallRealMethod();

        productController.getSingleProduct(id);
        assertEquals(id, idCaptor.getValue());


        verify(productService).getSingleProduct(idCaptor.capture());
        verify(productService, times(1)).getSingleProduct(any());

    }
}