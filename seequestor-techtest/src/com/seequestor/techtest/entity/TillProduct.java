package com.seequestor.techtest.entity;

import com.seequestor.techtest.rules.Pricing;

public class TillProduct {
	
	private Product item;
	private int qty = 0;
	private Pricing pricingRules = null;
	
	/**
	 * @param {Product} item - the item to add to the till
	 * @param {int} qty - the quantity to add
	 */
	public TillProduct(Product item , int qty)
	{
		this.item = item;
		this.qty = qty;
		this.pricingRules = new Pricing();	
	}
	/**
	 * @return {Product}
	 */
	public Product getItem() {
		return this.item;
	}
	/**
	 * @return {int} quantity
	 */
	public int getQty() {
		return this.qty;
	}
	/**
	 * @param {int} qty
	 * @return {TillProduct}
	 */
	public TillProduct setQty(int qty)
	{
		this.qty = qty;
		return this;
	}
	/**
	 * @return {double} the product cost.
	 */
	public double getTotalCost() {
		
		if ( this.pricingRules.ruleMet(this) )
		{
			return this.pricingRules.getNewPrice(this);
			
		} else {
			return this.getItem().getUnitPrice() * this.getQty();
		}
	}
}
