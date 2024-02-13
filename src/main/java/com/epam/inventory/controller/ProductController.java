package com.epam.inventory.controller;

import com.epam.inventory.model.Product;
import com.epam.inventory.service.ProductService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping
  public List<Product> getAllProducts() {
    return productService.getAllProducts();
  }

  @PostMapping
  public ResponseEntity<Product> addProduct(@RequestBody Product product) {
    Product productFromDb = productService.addProduct(product);
    return ResponseEntity.created(URI.create("")).body(productFromDb);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
    product.setId(id);
    Product productFromDb = productService.updateProduct(product);
    return ResponseEntity.ok(productFromDb);
  }
}
