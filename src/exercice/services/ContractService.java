package exercice.services;


import exercice.entities.Contract;
import exercice.entities.Installment;

import java.util.Calendar;
import java.util.Date;

public class ContractService {

    private OnlinePaymentServices onlinePaymentServices;

    public ContractService(OnlinePaymentServices onlinePaymentServices) {
        this.onlinePaymentServices = onlinePaymentServices;
    }

    public void processContract(Contract contract, int months) {
        double cota = contract.getTotalValue() / months;
        for (int x = 1; x <= months; x++) {
            Date date = addMonths(contract.getDateStart(), x);
            double cotaAtualizada = cota + onlinePaymentServices.interest(cota, x);
            double cotaCompleta = cotaAtualizada + onlinePaymentServices.paymentFee(cotaAtualizada);
            contract.addInstallment(new Installment(date, cotaCompleta));
        }
    }

    private Date addMonths(Date date, int number) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, number);
        return cal.getTime();
    }
}
