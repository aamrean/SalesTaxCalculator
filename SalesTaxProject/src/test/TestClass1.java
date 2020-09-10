package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.main.NonTaxableProduct;
import com.main.Product;
import com.main.ShoppingCartClient;
import com.main.TaxableProduct;

//Test case for input1
public class TestClass1 {
	Product product1,product2,product3;
	@Before
	public void setup() {
		ArrayList<Product> productList1=new ArrayList<Product>();
		product1=new NonTaxableProduct("book", 1, false, 12.49);
		product2=new TaxableProduct("music CD",1,false,14.99);
		product3=new NonTaxableProduct("chocolate bar", 1, false, 0.85);
		productList1.add(product1);
		productList1.add(product2);
		productList1.add(product3);
		ShoppingCartClient.salesTax=0;
		ShoppingCartClient.total=0;
		ShoppingCartClient.calculateSalesTax(productList1);
		//ShoppingCartClient.displayFinal(productList1);
	}

	
	@Test
	public void checkNonTaxProductPrice() {
		//assertEquals();
		assertEquals(product1.getPrice(), 12.49,0.0);
		assertEquals(product3.getPrice(),0.85,0.0);
	}
	
	@Test
	public void checkTaxProductPrice() {
		assertEquals(product2.getPrice(),16.49,0.0);
	}
	
	@Test
	public void checkProductSalesTax() {
		assertEquals(product2.getSalesTax(),1.50,0.0);
	}
	
	@Test
	public void checkTotalSalesTax() {
		assertEquals(ShoppingCartClient.salesTax,1.50,0.0);
	}
	
	@Test 
	public void checkTotal() {
		assertEquals(ShoppingCartClient.total,29.83,0.0);
	}
}
