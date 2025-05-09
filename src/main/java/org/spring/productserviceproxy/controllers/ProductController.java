package org.spring.productserviceproxy.controllers;

import org.spring.productserviceproxy.clients.IClientProductDto;
import org.spring.productserviceproxy.dtos.ProductDto;
import org.spring.productserviceproxy.services.FakeStoreProductService;
import org.spring.productserviceproxy.models.Categories;
import org.spring.productserviceproxy.models.Product;
import org.spring.productserviceproxy.services.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// This controller will always answer products
@RestController
@RequestMapping("/products")
public class ProductController {

    IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(this.productService.getAllProducts(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long productId) {
        try {
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.add("Accept", "application/json");
            headers.add("Content-Type", "application/json");
            headers.add("auth-token", "heyaccess");
            Product product = this.productService.getSingleProduct(productId);
            if(productId < 1) {
                throw new IllegalArgumentException("Something went wrong");
            }
            ResponseEntity<Product> responseEntity = new ResponseEntity<>(product, headers, HttpStatus.OK);
            return responseEntity;
        } catch (Exception e) {
            //ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            //return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 500 error code
            throw e;
        }
    }

    @PostMapping()
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto productDto) {
        Product product = getProduct(productDto);
        Product savedproduct = this.productService.addNewProduct(product);
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(savedproduct, HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable("productId") Long productId) {
        return "Updating product";
    }

    @PatchMapping("/{productId}")
    public Product patchProduct(@PathVariable("productId") Long productId, @RequestBody ProductDto productDto) {

        Product product = new Product();
        product.setId(productDto.getId());
        product.setCategory(new Categories());
        product.getCategory().setName(productDto.getCategory());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        return this.productService.updateProduct(productId, product);
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId) {
        return "Deleting a product with id: " + productId;
    }

    //@ExceptionHandler({NullPointerException.class, IllegalArgumentException.class})
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>("Kuch toh phat hai", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private Product getProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        Categories category = new Categories();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        product.setImageUrl(productDto.getImage());
        product.setDescription(productDto.getDescription());
        return product;
    }
}