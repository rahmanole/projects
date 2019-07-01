package controller.pojo;


public class Manager {
    private int id;
    private int cardNo;
    private String monthName;
    private String year;
    private String pin;

    public Manager(int id, int cardNo, String monthName, String year, String pin) {
        this.id = id;
        this.cardNo = cardNo;
        this.monthName = monthName;
        this.year = year;
        this.pin = pin;
    }

    public Manager(int cardNo, String monthName, String year, String pin) {
        this.cardNo = cardNo;
        this.monthName = monthName;
        this.year = year;
        this.pin = pin;
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

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    
    
    
    
}
