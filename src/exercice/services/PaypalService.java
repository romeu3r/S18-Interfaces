package exercice.services;

public class PaypalService implements OnlinePaymentServices {

    private static double fee_percentage = 0.02;
    private static double monthly_interest = 0.01;

    public double paymentFee(Double amount) {
        return amount * fee_percentage;
    }

    public double interest(Double amount, int months) {
        return amount * monthly_interest * months;
    }
}
