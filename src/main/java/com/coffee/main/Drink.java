package com.coffee.main;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * This enum class lists the drinks, along with the amount of
 * ingredients needed to make that drink, this approach allows for easy addition of future drinks.
 */
public enum Drink {
    COFFEE("Coffee", "3 COFFEE", "1 SUGAR", "1 CREAM"),
    DECAF_COFFEE("Decaf Coffee", "3 DECAF_COFFEE", "1 SUGAR", "1 CREAM"),
    CAFFE_LATTE("Caffe Latte", "2 ESPRESSO", "1 STEAMED_MILK"),
    CAFFE_AMERICANO("Caffe Americano", "3 ESPRESSO"),
    CAFFE_MOCHA("Caffe Mocha", "1 ESPRESSO", "1 COCOA", "1 STEAMED_MILK", "1 WHIPPED_CREAM"),
    CAPPUCCINO("Cappuccino", "2 ESPRESSO", "1 STEAMED_MILK", "1 FOAMED_MILK");

    private final String name;
    private final Map<Ingredient, Integer> ingredients;
    private final BigDecimal cost;

    Drink(String name, String... recipe) {
		Map<Ingredient, Integer> map = new HashMap<Ingredient, Integer>();
		BigDecimal cost = BigDecimal.ZERO;
		for (String spec : recipe) {
			String[] ingredientsTotal = spec.split(" ", 2);
			int quantity = (ingredientsTotal.length > 1) ? Integer.parseInt(ingredientsTotal[0]) : 1;
			String ingredientsNeeded = ingredientsTotal[ingredientsTotal.length - 1];
			Ingredient ingredient = Enum.valueOf(Ingredient.class, ingredientsNeeded);

			map.put(ingredient, quantity);
			cost = cost.add(ingredient.getCost().multiply(new BigDecimal(quantity)));
		}
		this.name = name;
		this.ingredients = Collections.unmodifiableMap(map);
		this.cost = cost;
	}

	public Map<Ingredient, Integer> getRecipe() {
		return this.ingredients;
	}

	public BigDecimal getPrice() {
		return this.cost;
	}

	public String toString() {
		return this.name;
	}
}