package exercice.services;

public interface OnlinePaymentServices {
    public double paymentFee(Double amount);

    public double interest(Double amount, int months);
}
