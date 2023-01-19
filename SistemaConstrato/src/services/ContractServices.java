package services;

import java.util.Calendar;
import java.util.Date;

import entities.Contract;
import entities.Installment;

public class ContractServices {


	private OnlineServices onlineServices;

	public ContractServices(OnlineServices onlineServices) {
		this.onlineServices = onlineServices;
	}
	
	public void processContract (Contract contract, int months) {
		double basicQuota = contract.getTotalValue() / months;
		for(int i = 1; i <= months; i++) {
			double updateQuota = basicQuota + onlineServices.interator(basicQuota, i);
			double fullQuota = updateQuota + onlineServices.PaymentEe(updateQuota);
			Date dueDate = addMonths(contract.getDate(), i);
			contract.getInstallments().add(new Installment(dueDate, fullQuota));
		}
	}
	
	private Date addMonths (Date date, int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, n);
		return calendar.getTime();
	}
	
	
}
