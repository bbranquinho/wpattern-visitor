package br.com.wpattern.visitor.utils.beans;

public class QuotationBean extends BaseBean {

	private static final long serialVersionUID = 7418565872739927605L;

	private String symbol;

	private double lastPrice;

	public QuotationBean() {
	}

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public double getLastPrice() {
		return this.lastPrice;
	}

	public void setLastPrice(double lastPrice) {
		this.lastPrice = lastPrice;
	}

}
