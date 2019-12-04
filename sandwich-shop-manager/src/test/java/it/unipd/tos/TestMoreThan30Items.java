package it.unipd.tos;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import it.unipd.tos.business.Bill;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.MenuItem.ItemType;
import it.unipd.tos.business.exception.TakeAwayBillException;

public class TestMoreThan30Items {

	@Test
	public void test() {
		List<MenuItem> menu=new ArrayList<>();
		for(int i=0; i<35;i++) {
			menu.add(new MenuItem(ItemType.Panini, "Caprese",5.5));
		}
		Bill contoMenu=new Bill();
		try {
			contoMenu.getOrderPrice(menu);
			
		}catch(TakeAwayBillException Eccezione) {
			if(Eccezione.getError()!="Too Many Items")
				fail("Function Will Continue to Calculate Total Price");
			else {
				System.err.print(Eccezione.getError());
			}
		}
		
	}

}