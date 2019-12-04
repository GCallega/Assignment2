////////////////////////////////////////////////////////////////////
// [GIACOMO] [CALLEGARI] [1122658]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import java.util.List;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;

public class Bill implements TakeAwayBill{

    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered) throws TakeAwayBillException {
        if(itemsOrdered == null)
        {throw new TakeAwayBillException("Empty Menu");}
        double totale=0.0, totaleCibo=0.0, totaleBevande=0.0;
        int countPanini=0;
        double PaninoMin=Double.MAX_VALUE;

        if(itemsOrdered.size()>30)
        {throw new TakeAwayBillException("Too Many Items");}
        
        for(int i=0; i< itemsOrdered.size(); i=i+1) {
            MenuItem temp=itemsOrdered.get(i);
            if(temp.tipo.name()=="Bevande")
            {totaleBevande=totaleBevande+temp.price;}
            else{
                   if(temp.tipo.name()=="Panini") {
                       {countPanini++;}
                       if(temp.price<PaninoMin)
                       {PaninoMin=temp.price;}
                   }
                   totaleCibo=totaleCibo+temp.price;
            }

        }
        if(countPanini>=5) 
        {totaleCibo=totaleCibo-(PaninoMin/2);}

        totale=totaleCibo+totaleBevande;
        
        if(totaleCibo>=50) 
            {totale=totale-(totale * 0.1D);}
        
        if(totale<=10)
        {totale=totale+0.5D;}
        
        return totale;
    }

}
