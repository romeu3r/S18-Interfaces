package exercice.application;

import exercice.entities.Contract;
import exercice.entities.Installment;
import exercice.services.ContractService;
import exercice.services.PaypalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

        System.out.println("Enter contract data");
        System.out.print("Number: ");
        int contractNB = sc.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        Date start = sdf.parse(sc.next());
        System.out.print("Contract value: ");
        double contractValue = sc.nextDouble();

        Contract cv = new Contract(contractNB, start, contractValue);

        System.out.print("Enter number of installments: ");
        int installments = sc.nextInt();/*parcelas*/
        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(cv, installments);

        System.out.println("Installments:");
        for (Installment x : cv.getInstallments()) {
            System.out.println(x);
        }
        sc.close();
    }
}
