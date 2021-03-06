package com.seequestor.techtest.rules;

import com.seequestor.techtest.entity.TillProduct;

public abstract class PricingRule {
	
	/**
	 * example
	 * [1,3,5,10,20]
	 */
	public abstract int[] getQuantityBreaks();
	/**
	 * Using above example, match with:
	 * [50.00 , 43.33 , 36.33 , 29.33 , 22.33]
	 */
	public abstract int[] getPriceBreaks();
	
	public double getNewPrice(TillProduct product) {
		
		for ( int i = 0;i < this.getQuantityBreaks().length; i++)
		{
			int qty = this.getQuantityBreaks()[i];
			int price = this.getPriceBreaks()[i];
			
			if ( product.getQty() >= qty ) {
				if (this.getQuantityBreaks().length != i + 1) {
					int next = this.getQuantityBreaks()[i + 1];
					
					if ( next < product.getQty() ) {
						continue;
					}
					
					return qty * price;
				}
			}
		}
		return product.getTotalCost();
	}
}
