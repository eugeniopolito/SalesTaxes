package it.ep.salesTaxes.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds the goods list.
 * 
 * @author eugenio
 *
 */
public class Receipt {

	private List<Good> goods;
	
	public Receipt() {
		goods = new ArrayList<Good>();
	}
	
	public Receipt(List<Good> goods) {
		this.goods = goods;
	}
	
	public void addGood(Good good) {
		goods.add(good);
	}

	public List<Good> getGoods() {
		return goods;
	}

	public void setGoods(List<Good> goods) {
		this.goods = goods;
	}
	
}
