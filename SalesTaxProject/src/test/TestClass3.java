package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.main.NonTaxableProduct;
import com.main.Product;
import com.main.ShoppingCartClient;
import com.main.TaxableProduct;

//Test case for input3
public class TestClass3 {
	Product product1,product2,product3,product4;
	
	@Before
	public void setup() {
		ArrayList<Product> productList1=new ArrayList<Product>();
		product1=new TaxableProduct("bottle of perfume", 1, true, 27.99);
		product2=new TaxableProduct("bottle of perfume",1,false,18.99);
		product3=new NonTaxableProduct("packet of headache pills", 1, false, 9.75);
		product4=new NonTaxableProduct("box of chocolates", 1, true, 11.25);
		productList1.add(product1);
		productList1.add(product2);
		productList1.add(product3);
		productList1.add(product4);
		ShoppingCartClient.salesTax=0;
		ShoppingCartClient.total=0;
		ShoppingCartClient.calculateSalesTax(productList1);
	}
	
	@Test
	public void checkNonTaxProductPrice() {
		//assertEquals();
		assertEquals(product3.getPrice(), 9.75,0.0);
		assertEquals(product4.getPrice(), 11.80,0.0);
	}
	
	@Test
	public void checkTaxProductPrice() {
		assertEquals(product1.getPrice(),32.19,0.0);
		assertEquals(product2.getPrice(),20.89,0.0);
	}
	
	@Test
	public void checkProductSalesTax() {
		assertEquals(product1.getSalesTax(),4.2,0.0);
		assertEquals(product2.getSalesTax(),1.9,0.0);
		assertEquals(product4.getSalesTax(),0.55,0.0);
	}
	
	@Test
	public void checkTotalSalesTax() {
		assertEquals(ShoppingCartClient.salesTax,6.65,0.0);
	}
	
	@Test 
	public void checkTotal() {
		assertEquals(ShoppingCartClient.total,74.63,0.0);
	}
	
	
}
