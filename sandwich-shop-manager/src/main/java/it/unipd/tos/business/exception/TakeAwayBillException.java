////////////////////////////////////////////////////////////////////
// [GIACOMO] [CALLEGARI] [1122658]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business.exception;

public class TakeAwayBillException extends Throwable{
    private String error;
    public TakeAwayBillException(String e) {
        error=e;
    }
    public String getError() {
        return error;
    }
    private static final long serialVersionUID = 1L;
}
