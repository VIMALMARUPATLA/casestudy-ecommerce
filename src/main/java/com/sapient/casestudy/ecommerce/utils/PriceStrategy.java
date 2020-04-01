package com.sapient.casestudy.ecommerce.utils;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sapient.casestudy.ecommerce.model.ShoppingCartEntry;

@Component
public interface PriceStrategy {
	
	public double getTotal(List<ShoppingCartEntry> shoppingCartEntries);
	
}
