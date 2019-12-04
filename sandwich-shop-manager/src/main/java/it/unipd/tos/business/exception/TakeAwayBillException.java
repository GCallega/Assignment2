package it.unipd.tos.business.exception;

public class TakeAwayBillException extends Throwable {
	private String error;
	public TakeAwayBillException(String e) {
		error=e;
	}
	public String getError() {
		return error;
	}

}
