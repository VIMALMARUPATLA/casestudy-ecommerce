package com.sapient.casestudy.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.casestudy.ecommerce.model.Product;
import com.sapient.casestudy.ecommerce.model.ShoppingCartMap;
import com.sapient.casestudy.ecommerce.service.ProductService;

@RestController
@RequestMapping(value = "/services")
public class RestServicesController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ShoppingCartMap shoppingCartMap;

	@RequestMapping("/addToCart")
	public void addToCart(
			@RequestParam(value = "productCode") String productCode, 
			@RequestParam(value = "quantity") int quantity
	) {
		shoppingCartMap.addItem(productCode, quantity);
	}

	@RequestMapping(value = "/getProducts", method = RequestMethod.GET)
	public @ResponseBody List<Product> getProducts() {
		return productService.findAll();
	}
	
    @RequestMapping(value = "/getProductByID/{productID}", method = RequestMethod.GET)
    public @ResponseBody Optional<Product> getProductByID(@PathVariable String productID) {
        return productService.findByProductID(productID);
    }
	
    @RequestMapping(value = "/findProductsByName/{searchName}", method = RequestMethod.GET)
    public @ResponseBody List<Product> findProductsByName(@PathVariable String searchName) {
        return productService.findProductsByName(searchName);
    }	
	
	@RequestMapping(value = "/getProductByProductCode/{productCode}", method = RequestMethod.GET)
	public @ResponseBody Product getProductByProductCode(@PathVariable String productCode) {
		return productService.findByProductCode(productCode);
	}
	
    @RequestMapping(value = "/getProductsByProductSize/{productSize}", method = RequestMethod.GET)
    public @ResponseBody List<Product> getProductsByProductSize(@PathVariable int productSize) {
        return productService.findByProductSize(productSize);
    }	
	
    @RequestMapping(value = "/getProductsByProductColour/{productColour}", method = RequestMethod.GET)
    public @ResponseBody List<Product> getProductsByProductColour(@PathVariable String productColour) {
        return productService.findByproductColour(productColour);
    }
    
    @RequestMapping(value = "/getProductsBetweenPriceRange/{minimumPrice}/{maximumPrice}", method = RequestMethod.GET)
    public @ResponseBody List<Product> getProductsBetweenPriceRange(@PathVariable double minimumPrice, @PathVariable double maximumPrice) {
        return productService.findProductsBetweenPriceRange(minimumPrice, maximumPrice);
    }
    
    @RequestMapping(value = "/addNewProduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String addNewProduct(@RequestBody Product product) {
        productService.save(product);
        return "Successfully added new Product "+product.getProductName();
    }

    @RequestMapping(value = "/addNewListOfProducts", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String addNewListOfProducts(@RequestBody List<Product> listOfProducts) {
        productService.saveAll(listOfProducts);
        return "Successfully added new Products!";
    }
    
    @RequestMapping(value = "/deleteProductByID/{productID}", method = RequestMethod.GET)
    public @ResponseBody String deleteProductByID(@PathVariable String productID) {
        productService.delete(productID);
        return "Succefully deleted Product with ID "+productID;
    }
    
    @RequestMapping(value = "/deleteProduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String deleteProduct(@RequestBody Product product) {
        productService.delete(product);
        return "Successfully deleted Product "+product.getProductName();
    }
    
    @RequestMapping(value = "/deleteAllProducts", method = RequestMethod.GET)
    public @ResponseBody String deleteAllProducts() {
        productService.deleteAll();
        return "Successfully deleted all Products!";
    }
}