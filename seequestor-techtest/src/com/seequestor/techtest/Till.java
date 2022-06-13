package com.seequestor.techtest;

import java.util.ArrayList;

import com.seequestor.techtest.entity.Product;
import com.seequestor.techtest.entity.TillProduct;

public class Till {
	/**
	 * @info - No Constructor needed.
	 */
	private ArrayList<TillProduct> basket = new ArrayList<TillProduct>();
	private ArrayList<String> log = new ArrayList<String>();
	
	/**
	 * @return {String} the till log.
	 */
	public String getLog() {
		String out = "";
		
		for ( int i = 0;i < log.size();i++ ) {
			out += log.get(i) + "\n";
		}
		
		return out;
	}
	/**
	 * @param {String} str - the string to log.
	 * @return {Till}
	 */
	public Till logString(String str) {
		this.log.add(str);
		return this;
	}
	/**
	 * @param {Product} product - the product to scan
	 * @param {int} amount - the qty in the basket.
	 * @return {Till}
	 */
	public Till scanProduct(Product product , int amount) {
		if ( this.hasProductInBasket(product) )
		{
			//add the amount, rather than set the amount.
			this.addQuantity(product , amount);
			this.logString("Updated Product(SKU: " + product.getSKU() + "), Added " + amount + ", cart total:" + this.getTotalValue());
		} else {
			this.basket.add(new TillProduct(product , amount));
			this.logString("Added Product(SKU: " + product.getSKU() + "), Qty: " + amount + ", cart total:" + this.getTotalValue());
		}
		return this;
	}
	/**
	 * @param {Product} product - the product to revoke.
	 * @return {Till}
	 */
	public Till voidProduct(Product product) {
		
		for ( int i = 0;i < this.basket.size(); i++ )
		{
			if ( this.basket.get(i).getItem().equals(product) )
			{
				this.basket.remove(i);
			}
		}
		
		this.logString("Revoked Product (SKU:" + product.getSKU() + ")" + ", cart total:" + this.getTotalValue());
		
		return this;
	}
	/**
	 * @param {Product} product - the product to amend
	 * @param {int} extra - the extra amounts to amend.
	 * @return {Till}
	 */
	public Till addQuantity(Product product , int extra) {
		TillProduct existing = this.getByProduct(product);
		
		int qty = existing.getQty();
		
		existing.setQty(qty + extra);
		return this;
	}
	
	/**
	 * @param {Product} product - the product to grab
	 * @return {TillProduct}
	 */
	public TillProduct getByProduct(Product product) {
		for ( int i = 0; i < this.basket.size(); i++ ) {
			TillProduct tillproduct = this.basket.get( i );
			
			if ( tillproduct.getItem().equals(product) ) {
				return tillproduct;
			}
		}
		return null;
	}
	/**
	 * @param {Product} product - the product to reference.
	 * @return {Boolean}
	 */
	public boolean hasProductInBasket(Product product) {
		for ( int i = 0; i < this.basket.size(); i++ ) {
			TillProduct tillproduct = this.basket.get( i );
			
			if ( tillproduct.getItem().equals(product) ) {
				return true;
			}
		}
		return false;
	}
	/**
	 * @return {double} total value of till.
	 */
	public double getTotalValue()
	{
		double value = 0.00;
		
		for(int i = 0;i < this.basket.size(); i++) {
			TillProduct item = this.basket.get(i);
			
			value += item.getTotalCost();
		}
		return value;
	}
}
