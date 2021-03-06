package com.seequestor.techtest.rules;

import java.util.ArrayList;

import com.seequestor.techtest.entity.TillProduct;

/**
 * SINCE I HAVENT GOT ANYWHERE I WILL BE
 * STORING INFORMATION I'LL BE HARDCODING
 * THE PRICING RULES.
 * 
 * NO CONSTRUCTOR EITHER. NO NEED FOR ONE
 * WITH THE CLASS.
 */
public class Pricing {
	
	private ArrayList<PricingRule> extraRules = new ArrayList<PricingRule>();
	
	/**
	 * @param {PricingRule} rule - add extra pricing rules.
	 * @return {Pricing}
	 */
	public Pricing addPricingRule(PricingRule rule)
	{
		this.extraRules.add(rule);
		return this;
	}
	/**
	 * @param {TillProduct} product
	 * @return {Boolean}
	 */
	public boolean ruleMet(TillProduct product)
	{
		switch ( product.getItem().getSKU() )
		{
			case "A":
				return product.getQty() >= 3;				
			case "B":
				return product.getQty() >= 2;
			default:
				//can be extended to allow PricingRule.
				return false;
		}
	}
	/**
	 * @param {TillProduct} product
	 * @return {double}
	 */
	public double getNewPrice(TillProduct product)
	{
		if ( this.ruleMet(product) ) {
			
			switch ( product.getItem().getSKU() )
			{
				case "A":
					
					int a_reduced = product.getQty() / 3;
					int a_remainder = product.getQty() % 3;
					
					double a_price = 0.00;
					
					a_price += a_reduced * 130;
					a_price += a_remainder * product.getTotalCost();
					
					return a_price;
				case "B":
					
					int b_reduced = product.getQty() / 2;
					int b_remainder = product.getQty() % 2;
					double b_price = 0.00;
					
					b_price += b_reduced * 45;
					b_price += b_remainder * product.getTotalCost();
					return b_price;
				default:
					//open this up to custom price ruling.
					
			}
			
		}
		return product.getQty() * product.getTotalCost();
	}
}
