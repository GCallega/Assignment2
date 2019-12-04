package it.unipd.tos;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import it.unipd.tos.business.Bill;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.MenuItem.ItemType;

public class TestSandwichDiscount {

	@Test
	public void test() {
		List<MenuItem> menu=new ArrayList<>();
		for(int i=0; i<13; i++) {
			menu.add(new MenuItem(ItemType.Panini, "Primavera", 2.0D));
		}
		menu.add(new MenuItem(ItemType.Panini, "Vegetariano", 1.0D));
		Bill contoMenu=new Bill();
		double totale=0;
		try {
			totale=contoMenu.getOrderPrice(menu);
		} catch (TakeAwayBillException Eccezione) {
			System.err.print(Eccezione.getError());
		}
		if(totale!=26.5D)
			fail("50% Discount application on cheaper sandwich failed (expected 26.5[2.0 * 13 + 50% of 1.0], got ".concat(Double.toString(totale)).concat("instead)"));
	}


}
