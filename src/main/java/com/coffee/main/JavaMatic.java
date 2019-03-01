package com.coffee.main;

import java.util.*;


/**
 * This is the main class for our coffee machine simulator.
 */
public class JavaMatic {

	private Map<Ingredient, Integer> inventory = new HashMap<Ingredient, Integer>();

	public int getInventory(Ingredient ingredient) {
		return this.inventory.containsKey(ingredient) ? this.inventory.get(ingredient) : 0;
	}

	public void restock() {
		for (Ingredient ingredient : Ingredient.values()) {
			if (this.getInventory(ingredient) < 10) {
				this.inventory.put(ingredient, 10);
			}
		}
	}

	public Drink[] menu() {
		return Drink.values();
	}

	public boolean canMake(Drink drink) {
		for (Map.Entry<Ingredient, Integer> ingredients : drink.getRecipe().entrySet()) {
			if (this.getInventory(ingredients.getKey()) < ingredients.getValue()) {
				return false;
			}
		}
		return true;
	}

	public void make(Drink drink) throws RuntimeException {
		if (!this.canMake(drink)) {
			throw new RuntimeException(drink.toString());
		}
		for (Map.Entry<Ingredient, Integer> quantityIngridents : drink.getRecipe().entrySet()) {
			int quantity = quantityIngridents.getValue();
			Ingredient stuff = quantityIngridents.getKey();
			this.inventory.put(stuff, this.getInventory(stuff) - quantity);
		}
	}

	public String toString() {
		StringBuilder out = new StringBuilder("Inventory:\n");
		for (Ingredient ingredient : Ingredient.values()) {
			out.append(ingredient).append(", ").append(this.getInventory(ingredient)).append('\n');
		}
		out.append("\nMenu:\n");
		int i = 0;
		for (Drink drink : Drink.values()) {
			out.append(++i).append(", ").append(drink).append(", $").append(drink.getPrice());
			if (this.canMake(drink)) {
				out.append(", True");
			} else {
				out.append(", False");
			}
			out.append('\n');
		}
		return out.toString();
	}

	public static void main(String[] args) {

		JavaMatic machine = new JavaMatic();
		machine.restock();
		System.out.printf("%s\n", machine);

		Scanner scanner = new Scanner(System.in);

		while (true) {

			System.out.printf("Select:");
			String selection = scanner.nextLine();

			if (selection.isEmpty()) {
				continue;
			} else if ("q".equalsIgnoreCase(selection)) {
				break;
			} else if ("r".equalsIgnoreCase(selection)) {
				machine.restock();
			} else
				try {
					int drinkSelection = Integer.parseInt(selection);
					Drink order = machine.menu()[drinkSelection - 1];
					machine.make(order);
					System.out.printf("Dispensing: %s\n", order);
				} catch (ArrayIndexOutOfBoundsException | NumberFormatException invalid) {
					System.out.printf("Invalid selection: %s\n", selection);
					continue;
				} catch (RuntimeException outOfStock) {
					System.out.printf("Out of stock: %s\n", outOfStock.getMessage());
					continue;
				}
			System.out.printf("%s\n", machine);
		}
		scanner.close();
	}

}