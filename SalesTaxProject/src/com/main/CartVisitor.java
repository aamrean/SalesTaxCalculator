package com.main;

//This is the abstract visitor
public interface CartVisitor {
	public int visit(TaxableProduct tax);
	public int visit(NonTaxableProduct nontax);
}
