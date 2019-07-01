/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.pojo;

/**
 *
 * @author OLEE
 */
public class MonthReport {

    private int totalMember;
    private int totalOnMeal;
    private int totalOffMeal;
    private int totalNormalOffMeal;
    private int totalFridayOffMeal;
    private int totalFeastOffMeal;
    private double totalExpenseCollection;
    private double totalSpent;
    private double balance;
    private int managerOneCardNo;
    private int managerTwoCardNo;

    public MonthReport(int totalMember, int totalOnMeal, int totalOffMeal, int totalNormalOffMeal, int totalFridayOffMeal, int totalFeastOffMeal, double totalExpenseCollection, double totalSpent, double balance, int managerOneCardNo, int managerTwoCardNo) {
        this.totalMember = totalMember;
        this.totalOnMeal = totalOnMeal;
        this.totalOffMeal = totalOffMeal;
        this.totalNormalOffMeal = totalNormalOffMeal;
        this.totalFridayOffMeal = totalFridayOffMeal;
        this.totalFeastOffMeal = totalFeastOffMeal;
        this.totalExpenseCollection = totalExpenseCollection;
        this.totalSpent = totalSpent;
        this.balance = balance;
        this.managerOneCardNo = managerOneCardNo;
        this.managerTwoCardNo = managerTwoCardNo;
    }

    public int getTotalNormalOffMeal() {
        return totalNormalOffMeal;
    }

    public void setTotalNormalOffMeal(int totalNormalOffMeal) {
        this.totalNormalOffMeal = totalNormalOffMeal;
    }



    public int getTotalFridayOffMeal() {
        return totalFridayOffMeal;
    }

    public void setTotalFridayOffMeal(int totalFridayOffMeal) {
        this.totalFridayOffMeal = totalFridayOffMeal;
    }

    public int getTotalFeastOffMeal() {
        return totalFeastOffMeal;
    }

    public void setTotalFeastOffMeal(int totalFeastOffMeal) {
        this.totalFeastOffMeal = totalFeastOffMeal;
    }

   
    

    public int getTotalMember() {
        return totalMember;
    }

    public void setTotalMember(int totalMember) {
        this.totalMember = totalMember;
    }

    public int getTotalOnMeal() {
        return totalOnMeal;
    }

    public void setTotalOnMeal(int totalOnMeal) {
        this.totalOnMeal = totalOnMeal;
    }

    public int getTotalOffMeal() {
        return totalOffMeal;
    }

    public void setTotalOffMeal(int totalOffMeal) {
        this.totalOffMeal = totalOffMeal;
    }

    public double getTotalExpenseCollection() {
        return totalExpenseCollection;
    }

    public void setTotalExpenseCollection(double totalExpenseCollection) {
        this.totalExpenseCollection = totalExpenseCollection;
    }

    public double getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(double totalSpent) {
        this.totalSpent = totalSpent;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getManagerOneCardNo() {
        return managerOneCardNo;
    }

    public void setManagerOneCardNo(int managerOneCardNo) {
        this.managerOneCardNo = managerOneCardNo;
    }

    public int getManagerTwoCardNo() {
        return managerTwoCardNo;
    }

    public void setManagerTwoCardNo(int managerTwoCardNo) {
        this.managerTwoCardNo = managerTwoCardNo;
    }

}
