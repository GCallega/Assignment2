package it.unipd.tos;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import it.unipd.tos.business.Bill;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.MenuItem.ItemType;

public class TestMoreThan50OnlyBevande {

	@Test
	public void test() {
		List<MenuItem> menu=new ArrayList<>();
		for(int i=0; i<15; i++) {
			menu.add(new MenuItem(ItemType.Bevande, "Aranciata", 4.0D));
		}
		Bill contoMenu=new Bill();
		double totale=0;
		try {
			totale=contoMenu.getOrderPrice(menu);
		} catch (TakeAwayBillException Eccezione) {
			System.err.print(Eccezione.getError());
		}
		if(totale!=60.0D)
			fail("Calculation of total price failed (expected 60.0[4.0 * 15 NO DISCOUNT], got ".concat(Double.toString(totale)).concat("instead)"));
	}
}
