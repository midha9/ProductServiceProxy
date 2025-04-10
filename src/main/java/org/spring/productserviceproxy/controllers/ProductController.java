package org.spring.productserviceproxy.controllers;

import org.spring.productserviceproxy.dtos.ProductDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping()
    public String getAllCategories() {
        return "Getting all categories";
    }
    @GetMapping("/{categoryId}")
    public String getProductInCategory(@PathVariable("categoryId") Long categoryId) {
        return "Get products in category";
    }

    @GetMapping("/")
    public String getSingleProduct() {
        return "Getting all the products";
    }

    @GetMapping("/{id}")
    public String getSingleProduct(@PathVariable("id") Long ProductId) {
        return "Returning Single Product with id: " + ProductId;
    }

    @PostMapping()
    public String addNewProduct(@RequestBody ProductDto productDto) {
        return "Adding new product" + productDto;
    }
    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable ("productId") Long productId ) {
        return "Updating product";
    }

   @DeleteMapping("/{productId")
    public String deleteProduct(@PathVariable("productId") Long productId) {
        return "Deleting product with id: " + productId;
   }

}
