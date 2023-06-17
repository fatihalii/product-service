package com.example.productservice.controllers;

import com.example.productservice.model.Product;
import com.example.productservice.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    public ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Optional<Product>> getProduct(@RequestBody String id){
        Optional<Product> p = productService.getProduct(id);
        return ResponseEntity.ok()
                .body(p);
    }

    @GetMapping("/getproducts")
    public ResponseEntity getAllProducts(){
        List products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public void createProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProduct(@RequestBody String id){
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted.");
    }


}
