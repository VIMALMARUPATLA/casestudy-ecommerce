package com.sapient.casestudy.ecommerce.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.casestudy.ecommerce.model.Product;
import com.sapient.casestudy.ecommerce.model.ShoppingCartEntry;
import com.sapient.casestudy.ecommerce.model.ShoppingCartMap;
import com.sapient.casestudy.ecommerce.service.ProductService;
import com.sapient.casestudy.ecommerce.utils.PriceStrategy;
import com.sapient.casestudy.ecommerce.utils.PriceStrategyRaw;
import com.sapient.casestudy.ecommerce.utils.PriceStrategyTax;
import com.sapient.casestudy.ecommerce.utils.PriceUtilities;

@Component
public class ShoppingHandlerImpl implements ShoppingHandler {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private PriceStrategy priceHandler;
	
	@Override
	public List<ShoppingCartEntry> getShoppingCartEntries(ShoppingCartMap shoppingCartMap) {
		List<ShoppingCartEntry> shoppingCarts = new ArrayList<>();
		
		for(String productCode : shoppingCartMap.getCartItems().keySet() ) {
			Product p = productService.findByProductCode(productCode);
			
			ShoppingCartEntry s = new ShoppingCartEntry();
			
			int quantity = shoppingCartMap.getQuantity(productCode);
			
			s.setImageUrl(p.getImageUrl());
			s.setProductName(p.getProductName());
			s.setPrice(p.getPrice());
			s.setProductTotalPrice( p.getPrice() * quantity );
			s.setQuantity(quantity);
			
			shoppingCarts.add(s);
		}
		
		return shoppingCarts;
	}

	@Override
	public String getTotalPrice(List<ShoppingCartEntry> shoppingCartEntries) {
		priceHandler = new PriceStrategyRaw();
		
		return PriceUtilities.roundToTwoDecimalPlaces(priceHandler.getTotal(shoppingCartEntries));
	}

	@Override
	public String getTotalTax(List<ShoppingCartEntry> shoppingCartEntries) {
		priceHandler = new PriceStrategyTax();
		
		return PriceUtilities.roundToTwoDecimalPlaces(priceHandler.getTotal(shoppingCartEntries));
	}
	
}
