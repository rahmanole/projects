package controller.pojo;

import java.sql.Date;


public class Meal {
    private int id;
    private Date date;
    private int totalActiveMember;
    private int totalOnMeals;
    private int totalOffMeal;
    private String mealType;
    private double actual_expensess;
    private double spent_expenss;
    private double balance;
    private String itemDetails;

    public Meal(int id, Date date, int totalActiveMember, int totalOnMeals, int totalOffMeal, String mealType, double actual_expensess, double spent_expenss, double balance, String itemDetails) {
        this.id = id;
        this.date = date;
        this.totalActiveMember = totalActiveMember;
        this.totalOnMeals = totalOnMeals;
        this.totalOffMeal = totalOffMeal;
        this.mealType = mealType;
        this.actual_expensess = actual_expensess;
        this.spent_expenss = spent_expenss;
        this.balance = balance;
        this.itemDetails = itemDetails;
    }

    public Meal(Date date, int totalActiveMember, int totalOnMeals, int totalOffMeal, String mealType, double actual_expensess, double spent_expenss, double balance, String itemDetails) {
        this.date = date;
        this.totalActiveMember = totalActiveMember;
        this.totalOnMeals = totalOnMeals;
        this.totalOffMeal = totalOffMeal;
        this.mealType = mealType;
        this.actual_expensess = actual_expensess;
        this.spent_expenss = spent_expenss;
        this.balance = balance;
        this.itemDetails = itemDetails;
    }

    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTotalActiveMember() {
        return totalActiveMember;
    }

    public void setTotalActiveMember(int totalActiveMember) {
        this.totalActiveMember = totalActiveMember;
    }

    public int getTotalOnMeals() {
        return totalOnMeals;
    }

    public void setTotalOnMeals(int totalOnMeals) {
        this.totalOnMeals = totalOnMeals;
    }

    public int getTotalOffMeal() {
        return totalOffMeal;
    }

    public void setTotalOffMeal(int totalOffMeal) {
        this.totalOffMeal = totalOffMeal;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public double getActual_expensess() {
        return actual_expensess;
    }

    public void setActual_expensess(double actual_expensess) {
        this.actual_expensess = actual_expensess;
    }

    public double getSpent_expenss() {
        return spent_expenss;
    }

    public void setSpent_expenss(double spent_expenss) {
        this.spent_expenss = spent_expenss;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(String itemDetails) {
        this.itemDetails = itemDetails;
    }
    
    
    
}
     