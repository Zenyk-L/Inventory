package com.epam.inventory.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.epam.inventory.dao.ProductRepository;
import com.epam.inventory.model.Product;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ProductServiceTest {

  @Mock
  private ProductRepository productRepository;

  @InjectMocks
  private ProductService productService;

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
    when(productRepository.findAll()).thenReturn(productList);

    // When
    List<Product> result = productService.getAllProducts();

    // Then
    assertEquals(2, result.size());
  }

  @Test
  public void testAddProduct() {
    // Given
    Product newProduct = new Product(null, "New Product", "New Description", 30.0, 300);
    when(productRepository.save(newProduct)).thenReturn(newProduct);

    // When
    Product result = productService.addProduct(newProduct);

    // Then
    assertEquals("New Product", result.getName());
    assertEquals("New Description", result.getDescription());
    assertEquals(30.0, result.getPrice());
    assertEquals(300, result.getQuantity());
  }

  @Test
  public void testUpdateProduct() {
    // Given
    Product existingProduct = new Product(1L, "Existing Product", "Existing Description", 50.0, 500);
    when(productRepository.save(existingProduct)).thenReturn(existingProduct);

    // When
    Product result = productService.updateProduct(existingProduct);

    // Then
    assertEquals("Existing Product", result.getName());
    assertEquals("Existing Description", result.getDescription());
    assertEquals(50.0, result.getPrice());
    assertEquals(500, result.getQuantity());
  }
}
