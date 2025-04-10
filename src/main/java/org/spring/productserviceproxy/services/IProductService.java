package org.spring.productserviceproxy.services;

import org.spring.productserviceproxy.dtos.ProductDto;

public interface IProductService {
    String getAllProducts();

    String getSingleProduct(Long productId);

    String addNewProduct(ProductDto productDto);

    String updateProduct(Long productId);

    String deleteProduct(Long productId);
}
