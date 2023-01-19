package programmer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractServices;
import services.PaypalServices;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("######### APLICAÇÃO DE CONTRATO #########");
		System.out.println("Número: ");
		int number = sc.nextInt();
		System.out.println("Data: dd/MM/yyy");
		Date date = sdf.parse(sc.next());
		System.out.println("Valor do Contrato: ");
		double totalValue = sc.nextDouble();
		
		Contract contract = new Contract(number, date, totalValue);
		
		System.out.println("Número de parcelas");
		int installmentParse = sc.nextInt();
		
		
		ContractServices cs = new ContractServices(new PaypalServices());
		
		cs.processContract(contract, installmentParse);
		
		System.out.println("Parcelas: ");
		
		for(Installment it : contract.getInstallments()) {
			System.out.println(it);
		}
		
		sc.close();
		
	}
}
