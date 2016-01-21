package it.ep.salesTaxes.business;

import it.ep.salesTaxes.model.Good;


/**
 * This interface must be implemented by all price calculators.
 * 
 * @author eugenio
 *
 */
public interface Calculator {
	
	public double computePrice(Good good);
	
	public double computeTaxes(Good good);

}
