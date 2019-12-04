package it.unipd.tos;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import it.unipd.tos.business.Bill;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.MenuItem.ItemType;

public class TestLessThan50Total {

	@Test
	public void test() {
		List<MenuItem> menu=new ArrayList<>();
		for(int i=0; i<10; i++) {
			menu.add(new MenuItem(ItemType.Bevande, "Aranciata", 1.D));
		}
		for(int j=0; j<10; j++) {
			menu.add(new MenuItem(ItemType.Fritti, "Arancini", 1.5D));
		}
		Bill contoMenu=new Bill();
		double totale=0;
		try {
			totale=contoMenu.getOrderPrice(menu);
		} catch (TakeAwayBillException Eccezione) {
			System.err.print(Eccezione.getError());
		}
		if(totale!=25.0D)
			fail("Calculation of total price failed (expected 25.0[1.0 * 10 + 1.5 * 10 NO DISCOUNT], got ".concat(Double.toString(totale)).concat("instead)"));
	}

}
