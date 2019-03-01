package com.coffee.main;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;

public class JavaMaticTest {

	private JavaMatic machine;
	private Drink drink;
	private Ingredient ingredient;

	@Before
	public void setUp() {
		machine = new JavaMatic();
	}

	@Test
	public void canMakeDrinkTest() {

		Drink coffee = drink.valueOf("COFFEE");
		machine.restock();
		boolean makeDrink = machine.canMake(coffee);

		assertEquals(makeDrink, true);
	}

	@Test
	public void canMakeDrinkNoStockTest() {

		Drink coffee = drink.valueOf("COFFEE");
		boolean makeDrink = machine.canMake(coffee);

		assertEquals(makeDrink, false);
	}

	@Test
	public void inventoryTest() {

		machine.restock();
		int foamedMilk = machine.getInventory(ingredient.FOAMED_MILK);
		int cocoa = machine.getInventory(ingredient.COCOA);
		int coffee = machine.getInventory(ingredient.COFFEE);
		int cream = machine.getInventory(ingredient.CREAM);
		int espresso = machine.getInventory(ingredient.ESPRESSO);
		int steamedMilk = machine.getInventory(ingredient.STEAMED_MILK);
		int sugar = machine.getInventory(ingredient.SUGAR);
		int whippedCream = machine.getInventory(ingredient.WHIPPED_CREAM);

		assertEquals(foamedMilk, 10);
		assertEquals(cocoa, 10);
		assertEquals(coffee, 10);
		assertEquals(cream, 10);
		assertEquals(espresso, 10);
		assertEquals(steamedMilk, 10);
		assertEquals(sugar, 10);
		assertEquals(whippedCream, 10);

	}

	@Test
	public void inventoryBeforeReStockTest() {

		int foamedMilk = machine.getInventory(ingredient.FOAMED_MILK);

		assertEquals(foamedMilk, 0);

	}

}