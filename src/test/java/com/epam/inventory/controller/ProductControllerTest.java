package com.epam.inventory.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.epam.inventory.model.Product;
import com.epam.inventory.service.ProductService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ProductControllerTest {

  @Mock
  private ProductService productService;

  @InjectMocks
  private ProductController productController;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testGetAllProducts() {
    // Given
    List<Product> productList = new ArrayList<>();
    productList.add(new Product(1L, "Product 1", "Description 1", 10.0, 100));
    productList.add(new Product(2L, "Product 2", "Description 2", 20.0, 200));
    when(productService.getAllProducts()).thenReturn(productList);

    // When
    List<Product> result = productController.getAllProducts();

    // Then
    assertEquals(2, result.size());
  }

  @Test
  public void testAddProduct() {
    // Given
    Product newProduct = new Product(null, "New Product", "New Description", 30.0, 300);
    when(productService.addProduct(newProduct)).thenReturn(newProduct);

    // When
    ResponseEntity<Product> response = productController.addProduct(newProduct);

    // Then
    assertEquals(HttpStatus.CREATED, response.getStatusCode());
    assertEquals("New Product", response.getBody().getName());
    assertEquals("New Description", response.getBody().getDescription());
    assertEquals(30.0, response.getBody().getPrice());
    assertEquals(300, response.getBody().getQuantity());
  }

  @Test
  public void testUpdateProduct() {
    // Given
    Product existingProduct = new Product(1L, "Existing Product", "Existing Description", 50.0, 500);
    when(productService.updateProduct(existingProduct)).thenReturn(existingProduct);

    // When
    ResponseEntity<Product> response = productController.updateProduct(1L, existingProduct);

    // Then
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals("Existing Product", response.getBody().getName());
    assertEquals("Existing Description", response.getBody().getDescription());
    assertEquals(50.0, response.getBody().getPrice());
    assertEquals(500, response.getBody().getQuantity());
  }
}
