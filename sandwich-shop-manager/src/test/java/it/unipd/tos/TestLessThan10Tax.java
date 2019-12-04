////////////////////////////////////////////////////////////////////
// [GIACOMO] [CALLEGARI] [1122658]
////////////////////////////////////////////////////////////////////
package it.unipd.tos;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import it.unipd.tos.business.Bill;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.MenuItem.ItemType;

public class TestLessThan10Tax {

	@Test
	public void test() {
		List<MenuItem> menu=new ArrayList<>();
		for(int i=0; i<4; i++) {
			menu.add(new MenuItem(ItemType.Bevande, "Coca Cola", 2.0D));
		}
		Bill contoMenu=new Bill();
		double totale=0;
		try {
			totale=contoMenu.getOrderPrice(menu);
		} catch (TakeAwayBillException Eccezione) {
			System.err.print(Eccezione.getError());
		}
		if(totale!=8.5D)
			fail("0.5€ tax application failed (expected 8.5[2.0 * 4 + 0.5], got ".concat(Double.toString(totale)).concat("instead)"));
	}

}
