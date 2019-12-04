package it.unipd.tos;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import it.unipd.tos.business.Bill;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.business.exception.TakeAwayBillException;

public class TestEmptyList {

	@Test
	public void test() {
		List<MenuItem> menu=null;
		Bill contoMenu=new Bill();
		try {
			contoMenu.getOrderPrice(menu);
			
		}catch(TakeAwayBillException Eccezione) {
			if(Eccezione.getError()!="Empty Menu")
				fail("Segmentation fault will be verified");
			else {
				System.err.print(Eccezione.getError());
			}
		}
		
	}

}
