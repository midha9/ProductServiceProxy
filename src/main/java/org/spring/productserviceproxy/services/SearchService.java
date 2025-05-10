package org.spring.productserviceproxy.services;

import org.spring.productserviceproxy.models.Product;
import org.spring.productserviceproxy.repostries.ProductRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    private ProductRepo productRepo;

    public SearchService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Page<Product> searchProducts(String query, int pageNumber, int sizeOfPage) {
        return productRepo.findByTitleEquals(query, PageRequest.of(pageNumber, sizeOfPage));
    }
}