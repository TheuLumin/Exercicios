package services;

public class PaypalServices implements OnlineServices{

	static final double PAYMENT_EE = 0.02;
	static final double INTERATOR = 0.01;
	
	@Override
	public double PaymentEe(double amount) {
		return amount * PAYMENT_EE;
	}

	@Override
	public double interator(double amount, int months) {
		return amount * months * INTERATOR;
	}

}
