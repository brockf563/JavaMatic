package com.coffee.main;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class DrinkTest {

	private static Drink drink;

	@Test
	public void listAllDrinksTest() {

		Drink[] drinks = drink.values();
		
		assertEquals(drinks[0], drink.valueOf("COFFEE"));
		assertEquals(drinks[1], drink.valueOf("DECAF_COFFEE"));
		assertEquals(drinks[2], drink.valueOf("CAFFE_LATTE"));
		assertEquals(drinks[3], drink.valueOf("CAFFE_AMERICANO"));
		assertEquals(drinks[4], drink.valueOf("CAFFE_MOCHA"));
		assertEquals(drinks[5], drink.valueOf("CAPPUCCINO"));		
		
	}
	
	@Test
	public void listPriceTest() {

		Drink coffee = drink.valueOf("COFFEE");
		BigDecimal cost = new BigDecimal("2.75");

		assertEquals(cost, coffee.getPrice());
	}
	
	@Test
	public void listIngridentsTest() {

		Drink coffee = drink.valueOf("COFFEE");
		Map<Ingredient, Integer> ingredients = new HashMap<>();
		ingredients.put(Ingredient.COFFEE, 3);
		ingredients.put(Ingredient.CREAM, 1);
		ingredients.put(Ingredient.SUGAR, 1);

		assertEquals(ingredients, coffee.getRecipe());
	}
}
