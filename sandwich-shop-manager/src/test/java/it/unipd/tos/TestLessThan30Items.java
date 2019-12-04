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

public class TestLessThan30Items {

	@Test
	public void test() {
		List<MenuItem> menu=new ArrayList<>();
		for(int i=0; i<20; i++) {
			menu.add(new MenuItem(ItemType.Panini, "Primavera", 5.5D));
		}
		Bill contoMenu=new Bill();
		try {
			contoMenu.getOrderPrice(menu);
		} catch (TakeAwayBillException Eccezione) {
			if(Eccezione.getError()=="Too many items" || Eccezione.getError()=="Empty Menu")
				fail(Eccezione.getError());
			else {
				System.err.print(Eccezione.getError());
				return;
			}
		}
	}
}
