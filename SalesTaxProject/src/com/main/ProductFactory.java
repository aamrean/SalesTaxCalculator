package com.main;

//This is a factory class. 
//Depending on the name of the product it returns a NonTaxableProduct or Taxable Product
//To add more Products, add products in the factory.
public class ProductFactory {
	
	public Product getProduct(String product,int quantity,double price,boolean imported) {
		
		if(imported) {
			product=product.replace("imported ", "");
		}
		//add non-taxable products like food,medicine,books here.
		if(product.equalsIgnoreCase("book")||
				product.equalsIgnoreCase("chocolate bar")||
				product.equalsIgnoreCase("box of chocolates")|| 
				product.equalsIgnoreCase("packet of headache pills")) {
			return new NonTaxableProduct(product, quantity, imported, price);
		}
		else
			return new TaxableProduct(product, quantity, imported, price);
		
	}
}
