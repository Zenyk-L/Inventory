package com.epam.inventory.service;


import com.epam.inventory.dao.ProductRepository;
import com.epam.inventory.model.Product;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

  private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

  @Autowired
  private ProductRepository productRepository;


  public List<Product> getAllProducts() {
    logger.info("Getting all products from the database");
    return productRepository.findAll();
  }

  public Product addProduct(Product product) {
    logger.info("Adding a new product to the database");
    return productRepository.save(product);
  }

  public Product updateProduct(Product product) {
    logger.info("Updating product in the database");
    return productRepository.save(product);
  }
}
