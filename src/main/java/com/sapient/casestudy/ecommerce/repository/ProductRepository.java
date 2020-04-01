package com.sapient.casestudy.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.casestudy.ecommerce.model.Product;

/*
 * Repository Layer is responsible for retrievel of data
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

	  Product findByProductCodeContainingIgnoreCase(String productCode);
	  
	  List<Product> findProductsByProductNameContainingIgnoreCase(String searchString);
	  
      List<Product> findProductsByBrandNameContainingIgnoreCase(String brandName);

      List<Product> findByproductColourContainingIgnoreCase(String productColour);
      
      List<Product> findByProductSize(int productSize);

      List<Product> findProductsByPriceBetween(double price1, double price2);
}
