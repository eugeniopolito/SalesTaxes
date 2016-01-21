package it.ep.salesTaxes.service;

import java.util.List;

import it.ep.salesTaxes.model.Receipt;


/**
 * Specify the operations supported by the receipt calculator.
 * 
 * @author eugenio
 *
 */
public interface ReceiptCalculator {
	
	public double computeTotalPrice(Receipt receipt);
	
	public double computeTotalTaxes(Receipt receipt);
	
	public List<String> getGoodsPriceAndTax(Receipt receipt);

}
