package it.ep.salesTaxes.service;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ep.salesTaxes.config.CalculatorFactory;
import it.ep.salesTaxes.model.Good;
import it.ep.salesTaxes.model.Receipt;

/**
 * Exposes the operations for computing prices and taxes.
 * 
 * @author eugenio
 *
 */
@Service
public class ReceiptCalculatorImpl implements ReceiptCalculator {

	@Autowired
	private CalculatorFactory calculatorFactory;

	/**
	 * Compute the total price calling the right factory through the good type
	 * 
	 * @param receipt
	 * @return the computed price with taxes
	 */
	@Override
	public double computeTotalPrice(Receipt receipt) {
		Validate.notNull(receipt, "The receipt must not be null");
		Validate.notEmpty(receipt.getGoods(), "The receipt has no goods");
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator('.');
		dfs.setGroupingSeparator(',');
		DecimalFormat df = new DecimalFormat("#.##", dfs);
		double total = .0f;
		for (Good good : receipt.getGoods()) {
			total += calculatorFactory.getFactory(good.getType().getName()).computePrice(good);
		}
		return Double.valueOf(df.format(total));
	}

	/**
	 * Compute the total taxes calling the right factory through the good type
	 * 
	 * @param receipt
	 * @return the total taxes
	 */
	@Override
	public double computeTotalTaxes(Receipt receipt) {
		Validate.notNull(receipt, "The receipt must not be null");
		Validate.notEmpty(receipt.getGoods(), "The receipt has no goods");
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator('.');
		dfs.setGroupingSeparator(',');
		DecimalFormat df = new DecimalFormat("#.##", dfs);
		double total = .0f;
		for (Good good : receipt.getGoods()) {
			total += calculatorFactory.getFactory(good.getType().getName()).computeTaxes(good);
		}
		return Double.valueOf(df.format(total));
	}

	/**
	 * Get the goods names and prices.
	 * 
	 * @param receipt
	 * @return the list with names and prices
	 */
	public List<String> getGoodsPriceAndTax(Receipt receipt) {
		Validate.notNull(receipt, "The receipt must not be null");
		Validate.notEmpty(receipt.getGoods(), "The receipt has no goods");
		List<String> tmpList = new ArrayList<String>();
		for (Good good : receipt.getGoods()) {
			tmpList.add(good.toString());
		}
		return tmpList;
	}

}
