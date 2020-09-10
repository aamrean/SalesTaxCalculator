package com.main;
//This is the Concrete visitor
public class CartVisitorImpl implements CartVisitor{

	@Override
	public int visit(TaxableProduct tax) {

		double price= tax.getPrice();
		double salesTax=0;
		if(tax.isImported()==true)
			salesTax=.15*price;
		else
			salesTax=.1*price;
		// Sales tax rounded to nearest 0.05 value
		double roundedTax=Math.round(salesTax*20)/20.0;
		
		//
		tax.setPrice(Double.parseDouble(String.format("%.2f", price+roundedTax)));
		tax.setSalesTax(roundedTax);
		return 0;
	}

	@Override
	public int visit(NonTaxableProduct nontax) {
		// TODO Auto-generated method stub
		double price=nontax.getPrice();
		double salesTax=0;
		if(nontax.isImported()==true) {
			salesTax=.05*price;
		}
		// Sales tax rounded to nearest 0.05 value
		double roundedTax=Math.round(salesTax*20)/20.0;
		//round off price to two decimal places
		nontax.setPrice(Double.parseDouble(String.format("%.2f", price+roundedTax)));
		nontax.setSalesTax(roundedTax);
		return 0;
	}

}
