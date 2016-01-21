package it.ep.salesTaxes.config;

import it.ep.salesTaxes.business.Calculator;

/**
 * Retrieves factory calulator by its type (i.e. Basic, TaxFree, ...).
 * 
 * @author eugenio
 *
 */
public interface CalculatorFactory {

	Calculator getFactory(String factory);

}
