package br.com.wpattern.visitor.utils.beans;

import java.util.Date;

public class BookBean extends BaseBean {

	private static final long serialVersionUID = 963067697452332948L;

	private double price;

	private int quantity;

	private Date date;

	public BookBean() {
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
