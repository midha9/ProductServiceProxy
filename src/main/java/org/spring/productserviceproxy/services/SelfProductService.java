package org.spring.productserviceproxy.services;

import org.spring.productserviceproxy.models.Product;
import org.spring.productserviceproxy.repostries.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfProductService implements IProductService {

    ProductRepo productRepo;

    public SelfProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        return null;
    }

    @Override
    public Product addNewProduct(Product product) {
        this.productRepo.save(product);
        return product;
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public String deleteProduct(Long productId) {
        return null;
    }
}