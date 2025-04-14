package org.spring.productserviceproxy.services;


import org.spring.productserviceproxy.clients.IClientProductDto;
import org.spring.productserviceproxy.dtos.ProductDto;
import org.spring.productserviceproxy.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();

    Product getSingleProduct(Long productId);

    Product addNewProduct(Product product);

    Product updateProduct(Long productId, Product product);

    String deleteProduct(Long productId);
}