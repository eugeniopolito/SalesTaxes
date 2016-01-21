package it.ep.salesTaxes.model;

import java.util.Locale;

/**
 * Holds the good information: name, price, type and computed price including tax
 * 
 * @author eugenio
 *
 */
public class Good {
	
	private String name;
	
	private double price;
	
	private double priceWithTax;
	
	private GoodType type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPriceWithTax() {
		return priceWithTax;
	}

	public void setPriceWithTax(double priceWithTax) {
		this.priceWithTax = priceWithTax;
	}

	public GoodType getType() {
		return type;
	}

	public void setType(GoodType type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return name+": "+ String.format(Locale.ENGLISH, "%.2f", Double.valueOf(priceWithTax));
	}

}
