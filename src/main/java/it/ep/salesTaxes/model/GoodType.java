package it.ep.salesTaxes.model;

/**
 * Specifies the good type and its tax value:
 * 
 * - Basic 
 * - TaxFree 
 * - Export 
 * - ExportFree
 * 
 * @author eugenio
 *
 */
public enum GoodType {

	BASIC("Basic",10.0), TAX_FREE("TaxFree",0.0), EXPORT("Export",5.0), EXPORT_FREE("ExportFree",5.0);

	private final String name;
	
	private final double taxValue;

	private GoodType(final String name, double taxValue) {
		this.name = name;
		this.taxValue = taxValue;
	}

	public String getName() {
		return name;
	}

	public double getTaxValue() {
		return taxValue;
	}

	@Override
	public String toString() {
		return name;
	}

}
