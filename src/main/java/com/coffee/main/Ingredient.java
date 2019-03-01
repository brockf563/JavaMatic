package com.coffee.main;

import java.math.BigDecimal;

/**
 * This enum class lists the ingredients needed to make a drink, along with the cost
 * of each ingredient, this approach allows for easy addition of future ingredients.
 */
public enum Ingredient {
    COFFEE("Coffee","0.75"),
    DECAF_COFFEE("Decaf Coffee","0.75"),
    SUGAR("Sugar","0.25"),
    CREAM("Cream","0.25"),
    STEAMED_MILK("Steamed Milk","0.35"),
    FOAMED_MILK("Foamed Milk","0.35"),
    ESPRESSO("Espresso","1.10"),
    COCOA("Cocoa","0.90"),
    WHIPPED_CREAM("Whipped Cream", "1.00");

	private final String name;
	private final BigDecimal cost;

	Ingredient(String name, String cost) {
		this.name = name;
		this.cost = new BigDecimal(cost);
	}

	public BigDecimal getCost() {
		return this.cost;
	}

	public String toString() {
		return this.name;
	}
}