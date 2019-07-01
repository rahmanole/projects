package controller.pojo;

import java.sql.Date;

public class MonthlyExpense {
    private int id;
    private int cardNo;
    private double previous_month_bumpingMoney;
    private double needToPay ;
    private Date paymentDate;

    public MonthlyExpense(int id, int cardNo, double previous_month_bumpingMoney, double needToPay, Date paymentDate) {
        this.id = id;
        this.cardNo = cardNo;
        this.previous_month_bumpingMoney = previous_month_bumpingMoney;
        this.needToPay = needToPay;
        this.paymentDate = paymentDate;
    }

    public MonthlyExpense(int cardNo, double previous_month_bumpingMoney, double needToPay, Date paymentDate) {
        this.cardNo = cardNo;
        this.previous_month_bumpingMoney = previous_month_bumpingMoney;
        this.needToPay = needToPay;
        this.paymentDate = paymentDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public double getPrevious_month_bumpingMoney() {
        return previous_month_bumpingMoney;
    }

    public void setPrevious_month_bumpingMoney(double bumpingMoney) {
        this.previous_month_bumpingMoney = bumpingMoney;
    }

    public double getNeedToPay() {
        return needToPay;
    }

    public void setNeedToPay(double needToPay) {
        this.needToPay = needToPay;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
    
    
    
}
