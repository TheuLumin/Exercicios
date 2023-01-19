package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installment {
	
	private Date dueDate;
	private double amount;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Installment(Date dueDate, double amount) {
		super();
		this.dueDate = dueDate;
		this.amount = amount;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return sdf.format(dueDate) + " - " + String.format("" + amount);
	}
	
	
	
}
