/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.pojo;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author OLEE
 */
public class Summary {
    private int id;
    private int cardNo;
    private int totalMeals;
    private int onDays;
    private int normalOffDays;
    private int fridayOffMeal;
    private boolean wasFeastOn;
    private int totalOffMeal;
    private double bumping;
    private List<Date> offDates;

    public Summary(int id, int cardNo, int totalMeals,int onDays, int normalOffDays, int fridayOffMeal, boolean wasFeastOn, int totalOffMeal, double bumping,List<Date> offDates) {
        this.id = id;
        this.cardNo = cardNo;
        this.totalMeals = totalMeals;
        this.onDays = onDays;
        this.normalOffDays = normalOffDays;
        this.fridayOffMeal = fridayOffMeal;
        this.wasFeastOn = wasFeastOn;
        this.totalOffMeal = totalOffMeal;
        this.bumping = bumping;
        this.offDates = offDates;
    }

    public Summary(int cardNo,  int totalMeals,int onDays,int normalOffDays, int fridayOffMeal, boolean wasFeastOn, int totalOffMeal, double bumping,List<Date> offDates) {
        this.cardNo = cardNo;
        this.totalMeals = totalMeals;
        this.onDays = onDays;
        this.normalOffDays = normalOffDays;
        this.fridayOffMeal = fridayOffMeal;
        this.wasFeastOn = wasFeastOn;
        this.totalOffMeal = totalOffMeal;
        this.bumping = bumping;
        this.offDates = offDates;
    }

    public Summary(int cardNo,int totalMeals, int onDays, int normalOffDays, int fridayOffMeal, boolean wasFeastOn, int totalOffMeal, double bumping) {
        this.cardNo = cardNo;
        this.totalMeals = totalMeals;
        this.onDays = onDays;
        this.normalOffDays = normalOffDays;
        this.fridayOffMeal = fridayOffMeal;
        this.wasFeastOn = wasFeastOn;
        this.totalOffMeal = totalOffMeal;
        this.bumping = bumping;
    }

    public int getTotalMeals() {
        return totalMeals;
    }

    public void setTotalMeals(int totalMeals) {
        this.totalMeals = totalMeals;
    }

    public List<Date> getOffDates() {
        return offDates;
    }

    public void setOffDates(List<Date> offDates) {
        this.offDates = offDates;
    }
    
    

    public Summary(int cardNo, int onDays, int totalOffMeal, double bumping) {
        this.cardNo = cardNo;
        this.onDays = onDays;
        this.totalOffMeal = totalOffMeal;
        this.bumping = bumping;
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

    public int getOnDays() {
        return onDays;
    }

    public void setOnDays(int onDays) {
        this.onDays = onDays;
    }

    public int getNormalOffDays() {
        return normalOffDays;
    }

    public void setNormalOffDays(int normalOffDays) {
        this.normalOffDays = normalOffDays;
    }

    public int getFridayOffMeal() {
        return fridayOffMeal;
    }

    public void setFridayOffMeal(int fridayOffMeal) {
        this.fridayOffMeal = fridayOffMeal;
    }

    public boolean getWasFeastOn() {
        return wasFeastOn;
    }

    public void setWasFeastOn(boolean wasFeastOn) {
        this.wasFeastOn = wasFeastOn;
    }

    public int getTotalOffMeal() {
        return totalOffMeal;
    }

    public void setTotalOffMeal(int totalOffMeal) {
        this.totalOffMeal = totalOffMeal;
    }

    public double getBumping() {
        return bumping;
    }

    public void setBumping(double bumping) {
        this.bumping = bumping;
    }

    public Summary(List<Date> offDates) {
        this.offDates = offDates;
    }
}
