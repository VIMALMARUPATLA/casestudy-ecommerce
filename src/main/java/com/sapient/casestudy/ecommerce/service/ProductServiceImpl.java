package com.sapient.casestudy.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.casestudy.ecommerce.model.Product;
import com.sapient.casestudy.ecommerce.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product findByProductCode(String productCode) {
		return productRepository.findByProductCodeContainingIgnoreCase(productCode);
	}
	
	@Override
	public List<Product> findProductsByBrandName(String brandName) {
		return productRepository.findProductsByBrandNameContainingIgnoreCase(brandName);
	}

	@Override
	public List<Product> findProductsByName(String searchString) {
		return productRepository.findProductsByProductNameContainingIgnoreCase(searchString);
	}

    @Override
    public void save(Product product)
    {
        productRepository.save(product);   
    }
    
    @Override
    public void saveAll(List<Product> listOfProducts)
    {
        productRepository.saveAll(listOfProducts);
    }

    @Override
    public List<Product> findByproductColour(String productColour)
    {
        return productRepository.findByproductColourContainingIgnoreCase(productColour);
    }

    @Override
    public void delete(String id)
    {
        productRepository.deleteById(id);
    }
    
    @Override
    public void deleteAll()
    {
        productRepository.deleteAll();
    }

    @Override
    public void delete(Product product)
    {
        productRepository.delete(product);
    }

    @Override
    public List<Product> findByProductSize(int productSize)
    {
        return productRepository.findByProductSize(productSize);
    }

    @Override
    public Optional<Product> findByProductID(String productID)
    {
        return productRepository.findById(productID);
    }

    @Override
    public List<Product> findProductsBetweenPriceRange(double minimumPrice, double maximumPrice)
    {
        return productRepository.findProductsByPriceBetween(minimumPrice, maximumPrice);
    }
}
