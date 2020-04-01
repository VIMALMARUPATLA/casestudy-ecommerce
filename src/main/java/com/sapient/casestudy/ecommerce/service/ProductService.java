package com.sapient.casestudy.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sapient.casestudy.ecommerce.model.Product;

/*
 * Service Layer should be used for Transactional processes
 * 
 * Calls Repository Layers
 * 
 */
@Service
public interface ProductService {
	
    public void save(Product product);
    public void delete(String id);
    public void delete(Product product);
    public void deleteAll();
	public List<Product> findAll();
	public Optional<Product> findByProductID(String productID);
	public Product findByProductCode(String productCode);
	public List<Product> findByproductColour(String productColour);
	public List<Product> findByProductSize(int productSize);
	public List<Product> findProductsByName(String searchString);
    public List<Product> findProductsByBrandName(String brandName);
    public List<Product> findProductsBetweenPriceRange(double minimumPrice, double maximumPrice);
    public void saveAll(List<Product> listOfProducts);
}
