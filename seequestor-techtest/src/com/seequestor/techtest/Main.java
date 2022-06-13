package com.seequestor.techtest;

import com.seequestor.techtest.entity.Product;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Till till = new Till();
		
		Product[] collection = Main.loadProducts();
		
		till.scanProduct(collection[0], 1);
		till.scanProduct(collection[1], 1);
		
		
		till.voidProduct(collection[1]);
		
		till.scanProduct(collection[3], 1);
		till.scanProduct(collection[0], 1);
		
		
		System.out.print(till.getLog());
		
	}
	
	/**
	 * @description - Loads a collection of hard-coded products
	 * for the demo.
	 */
	public static Product[] loadProducts() {
		Product a = new Product("A", "Item A", 50.00);
		Product b = new Product("B", "Item B", 30.00);
		Product c = new Product("C", "Item C", 20.00);
		Product d = new Product("D", "Item D", 15.00);
		Product e = new Product("E", "Item E", 3.00);
		
		return new Product[] {
			a , b , c , d , e
		};
	}
}
