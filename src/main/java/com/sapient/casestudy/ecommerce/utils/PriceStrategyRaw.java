package com.sapient.casestudy.ecommerce.utils;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.sapient.casestudy.ecommerce.model.ShoppingCartEntry;

@Primary
@Component
public class PriceStrategyRaw implements PriceStrategy {

	@Override
	public double getTotal(List<ShoppingCartEntry> shoppingCartEntries) {
		double total = 0.0;
		
		for(ShoppingCartEntry e : shoppingCartEntries) {
			total += e.getProductTotalPrice();
		}
		
		return total;
	}

}
