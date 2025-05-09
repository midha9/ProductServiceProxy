package org.spring.productserviceproxy.controllers;

import org.spring.productserviceproxy.clients.fakestore.client.FakeStoreClient;
import org.spring.productserviceproxy.models.Product;
import org.spring.productserviceproxy.services.FakeStoreProductService;
import org.spring.productserviceproxy.services.IProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProductControllerTest {

    @Mock
    private FakeStoreClient fakeStoreClient;

    @Mock
    private FakeStoreProductService productService;

    @InjectMocks
    private ProductController productController;

    @Captor
    private ArgumentCaptor<Long> idCaptor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks and inject them
    }

    @Test
    void test_whenGetProductIsCalled_ReturnProducts() {
        // Arrange
        Product product = new Product();
        product.setId(2L);
        product.setTitle("test");
        when(productService.getSingleProduct(any(Long.class))).thenReturn(product);

        // Act
        ResponseEntity<Product> productResponseEntity = productController.getSingleProduct(2L);

        // Assert
        assertNotNull(productResponseEntity);
        assertEquals("test", productResponseEntity.getBody().getTitle());
    }

    @Test
    void test_whenGetProductIsCalled_ReturnException() {
        // Arrange
        when(productService.getSingleProduct(any(Long.class)))
                .thenThrow(new RuntimeException("Something is wrong"));

        // Act & Assert
        assertThrows(RuntimeException.class,
                () -> productController.getSingleProduct(2L));
    }

    @Test
    void test_productControllerCallsProductServiceWithSameId() {
        Long id = 2L;
        when(productService.getSingleProduct(id)).thenCallRealMethod();

        // Act
        productController.getSingleProduct(id);

        // Assert
        verify(productService).getSingleProduct(idCaptor.capture());
        verify(productService, times(1)).getSingleProduct(any());
        assertEquals(id, idCaptor.getValue());
    }

    @Test
    void test_productControllerCallsProductServiceWithSameId2() {
        Long id = 2L;
        when(productService.getSingleProduct(id)).thenCallRealMethod();

        // Act
        productController.getSingleProduct(id);

        // Assert
        verify(productService).getSingleProduct(idCaptor.capture());
        verify(productService, times(1)).getSingleProduct(any());
        assertEquals(id, idCaptor.getValue());
    }
}