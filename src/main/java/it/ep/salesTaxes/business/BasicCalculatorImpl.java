package it.ep.salesTaxes.business;

import org.springframework.stereotype.Component;

import it.ep.salesTaxes.model.Good;
import it.ep.salesTaxes.model.GoodType;

/**
 * The calculator for basic sales tax.
 * 
 * @author eugenio
 *
 */
@Component("Basic")
public class BasicCalculatorImpl implements Calculator {

	@Override
	public double computePrice(Good good) {
		double priceWithTax = good.getPrice() + computeTaxes(good);
		good.setPriceWithTax(priceWithTax);
		return priceWithTax;
	}

	@Override
	public double computeTaxes(Good good) {
		return Math.ceil((good.getPrice() * GoodType.BASIC.getTaxValue() / 100.0) / 0.05) * 0.05; 
	}

}
