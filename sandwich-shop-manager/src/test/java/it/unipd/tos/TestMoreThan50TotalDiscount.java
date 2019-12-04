package it.unipd.tos;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import it.unipd.tos.business.Bill;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.MenuItem.ItemType;


public class TestMoreThan50TotalDiscount {

	@Test
	public void test() {
		List<MenuItem> menu=new ArrayList<>();
		for(int i=0; i<20; i++) {
			menu.add(new MenuItem(ItemType.Fritti, "Olive ascolane", 3.0D));
		}
		for(int j=0; j<5; j++) {
			menu.add(new MenuItem(ItemType.Bevande, "Coca cola", 2.0D));
		}
		Bill contoMenu=new Bill();
		double totale=0;
		try {
			totale=contoMenu.getOrderPrice(menu);
		} catch (TakeAwayBillException Eccezione) {
			System.err.print(Eccezione.getError());
		}
		if(totale!=63.0D)
			fail("10% Discount application on total order failed (expected 63.0[90% of (3.0 * 20 + 2.0 * 5)], got ".concat(Double.toString(totale)).concat("instead)"));
	}

}
