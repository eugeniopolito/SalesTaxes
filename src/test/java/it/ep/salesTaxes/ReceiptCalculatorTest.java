package it.ep.salesTaxes;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import it.ep.salesTaxes.model.Good;
import it.ep.salesTaxes.model.GoodType;
import it.ep.salesTaxes.model.Receipt;
import it.ep.salesTaxes.service.ReceiptCalculator;

import static org.junit.Assert.assertEquals;


/**
 * These are the required test cases.
 * 
 * @author eugenio
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/test/resources/applicationContext.xml" })
public class ReceiptCalculatorTest {

	@Autowired
	private ReceiptCalculator receiptService;

	@Test
	public void testCase1() {
		List<Good> goodsList = new ArrayList<Good>();
		Good good = new Good();
		good.setName("book");
		good.setPrice(12.49);
		good.setType(GoodType.TAX_FREE);
		goodsList.add(good);
		
		good = new Good();
		good.setName("music CD");
		good.setPrice(14.99);
		good.setType(GoodType.BASIC);
		goodsList.add(good);
		
		good = new Good();
		good.setName("chocolate bar");
		good.setPrice(0.85);
		good.setType(GoodType.TAX_FREE);
		goodsList.add(good);
		
		Receipt receipt = new Receipt(goodsList);
		double totalPrice = receiptService.computeTotalPrice(receipt);
		double totalTaxes = receiptService.computeTotalTaxes(receipt);
		List<String> goodsPriceAndTax = receiptService.getGoodsPriceAndTax(receipt);
		
		assertEquals(goodsPriceAndTax.get(0), "book: 12.49");
		assertEquals(goodsPriceAndTax.get(1), "music CD: 16.49");
		assertEquals(goodsPriceAndTax.get(2), "chocolate bar: 0.85");
		
		assertEquals(totalPrice, 29.83, 0.0);
		assertEquals(totalTaxes, 1.50, 0.0);
	}
	
	
	@Test
	public void testCase2() {
		List<Good> goodsList = new ArrayList<Good>();
		Good good = new Good();
		good.setName("imported box of chocolates");
		good.setPrice(10.00);
		good.setType(GoodType.EXPORT_FREE);
		goodsList.add(good);
		
		good = new Good();
		good.setName("imported bottle of parfume");
		good.setPrice(47.50);
		good.setType(GoodType.EXPORT);
		goodsList.add(good);
		
		
		Receipt receipt = new Receipt(goodsList);
		double totalPrice = receiptService.computeTotalPrice(receipt);
		double totalTaxes = receiptService.computeTotalTaxes(receipt);
		List<String> goodsPriceAndTax = receiptService.getGoodsPriceAndTax(receipt);
		
		assertEquals(goodsPriceAndTax.get(0), "imported box of chocolates: 10.50");
		assertEquals(goodsPriceAndTax.get(1), "imported bottle of parfume: 54.65");
		
		assertEquals(totalPrice, 65.15, 0.0);
		assertEquals(totalTaxes, 7.65, 0.0);
	}
	
	
	@Test
	public void testCase3() {
		List<Good> goodsList = new ArrayList<Good>();
		Good good = new Good();
		good.setName("imported bottle of parfume");
		good.setPrice(27.99);
		good.setType(GoodType.EXPORT);
		goodsList.add(good);
		
		good = new Good();
		good.setName("bottle of parfume");
		good.setPrice(18.99);
		good.setType(GoodType.BASIC);
		goodsList.add(good);
		
		good = new Good();
		good.setName("packet of headhache pills");
		good.setPrice(9.75);
		good.setType(GoodType.TAX_FREE);
		goodsList.add(good);
		
		good = new Good();
		good.setName("imported box of chocolate");
		good.setPrice(11.25);
		good.setType(GoodType.EXPORT_FREE);
		goodsList.add(good);
		
		
		Receipt receipt = new Receipt(goodsList);
		double totalPrice = receiptService.computeTotalPrice(receipt);
		double totalTaxes = receiptService.computeTotalTaxes(receipt);
		List<String> goodsPriceAndTax = receiptService.getGoodsPriceAndTax(receipt);
		
		assertEquals(goodsPriceAndTax.get(0), "imported bottle of parfume: 32.19");
		assertEquals(goodsPriceAndTax.get(1), "bottle of parfume: 20.89");
		assertEquals(goodsPriceAndTax.get(2), "packet of headhache pills: 9.75");
		assertEquals(goodsPriceAndTax.get(3), "imported box of chocolate: 11.85");
		
		assertEquals(totalPrice, 74.68, 0.0);
		assertEquals(totalTaxes, 6.70, 0.0);
	}

}
