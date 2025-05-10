package org.spring.productserviceproxy.controllers;

import  org.spring.productserviceproxy.dtos.ProductDto;
import  org.spring.productserviceproxy.dtos.SearchRequestDto;
import  org.spring.productserviceproxy.models.Categories;
import  org.spring.productserviceproxy.models.Product;
import  org.spring.productserviceproxy.services.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping
    public Page<Product> searchProducts(@RequestBody SearchRequestDto searchRequestDto) {
//        List<Product> result = searchService.searchProducts(searchRequestDto.getQuery(),
//                searchRequestDto.getPageNumber(), searchRequestDto.getSizeOfPage());
//        List<ProductDto> shareableResult = new LinkedList<>();
//        for(Product product : result) {
//            shareableResult.add(getProduct(product));
//        }
//        return shareableResult;
        Page<Product> result = searchService.searchProducts(searchRequestDto.getQuery(),
                searchRequestDto.getPageNumber(), searchRequestDto.getSizeOfPage());
        return result;
    }

    private ProductDto getProduct(Product p) {
        ProductDto product = new ProductDto();
        product.setId(p.getId());
        product.setTitle(p.getTitle());
        product.setPrice(p.getPrice());
        return product;
    }

}