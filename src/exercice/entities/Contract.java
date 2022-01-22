package exercice.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
    private Integer number;
    private Date dateStart;
    private Double totalValue;

    private List<Installment> installments = new ArrayList<>();

    public Contract(Integer number, Date dateStart, Double totalValue) {
        this.number = number;
        this.dateStart = dateStart;
        this.totalValue = totalValue;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public List<Installment> getInstallments() {
        return installments;
    }

    public void addInstallment(Installment installment) {
        installments.add(installment);
    }

    public void removeInstallment(Installment installment) {
        installments.remove(installment);
    }
}
