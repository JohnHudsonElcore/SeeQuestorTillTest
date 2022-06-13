package com.seequestor.techtest.entity;

public class Product {
	
	private String SKU = "";
	private String name = "";
	private double UnitPrice = 0.00;
	
	public Product(String sku , String name , double UnitPrice) {
		this.setName(name)
	        .setSKU(sku)
	        .setUnitPrice(UnitPrice);
	}	
	/**
	 * @return {String} SKU
	 */
	public String getSKU() {
		return this.SKU;
	}

	/**
	 * @param {String} sku - the SKU of the product
	 * @return {Product}
	 */
	public Product setSKU(String sku) {
		this.SKU = sku;
		return this;
	}
	
	/**
	 * @param {String} name
	 * @return {Product}
	 */
	public Product setName(String name) {
		this.name = name;
		return this;
	}
	/**
	 * @return {String} name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * @param {double} price
	 * @return {Product}
	 */
	public Product setUnitPrice(double price) {
		this.UnitPrice = price;
		return this;
	}
	/**
	 * @return {double} unit price
	 */
	public double getUnitPrice() {
		return this.UnitPrice;
	}
}
