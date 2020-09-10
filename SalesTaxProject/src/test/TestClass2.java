package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.main.NonTaxableProduct;
import com.main.Product;
import com.main.ShoppingCartClient;
import com.main.TaxableProduct;

//Test case for input2
public class TestClass2 {

	Product product1,product2;
	@Before
	public void setup() {
		ArrayList<Product> productList1=new ArrayList<Product>();
		product1=new NonTaxableProduct("box of chocolates", 1, true, 10);
		product2=new TaxableProduct("bottle of perfume",1,true,47.50);
		
		productList1.add(product1);
		productList1.add(product2);
		
		ShoppingCartClient.salesTax=0;
		ShoppingCartClient.total=0;
		ShoppingCartClient.calculateSalesTax(productList1);
		//ShoppingCartClient.displayFinal(productList1);
	}
	
	@Test
	public void checkNonTaxProductPrice() {
		//assertEquals();
		assertEquals(product1.getPrice(), 10.5,0.0);
	}
	
	@Test
	public void checkTaxProductPrice() {
		assertEquals(product2.getPrice(),54.65,0.0);
	}
	
	@Test
	public void checkProductSalesTax() {
		assertEquals(product1.getSalesTax(),0.50,0.0);
		assertEquals(product2.getSalesTax(),7.15,0.0);
	}
	
	@Test
	public void checkTotalSalesTax() {
		assertEquals(ShoppingCartClient.salesTax,7.65,0.0);
	}
	
	@Test 
	public void checkTotal() {
		assertEquals(ShoppingCartClient.total,65.15,0.0);
	}
}
