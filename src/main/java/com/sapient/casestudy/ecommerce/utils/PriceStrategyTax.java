package com.sapient.casestudy.ecommerce.utils;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sapient.casestudy.ecommerce.model.ShoppingCartEntry;

@Component
public class PriceStrategyTax implements PriceStrategy {

	@Override
	public double getTotal(List<ShoppingCartEntry> shoppingCartEntries) {
		double total = 0.0;
		
		for(ShoppingCartEntry e : shoppingCartEntries) {
			total += e.getProductTotalPrice() * 0.18;
		}
		
		return total;
	}

}
