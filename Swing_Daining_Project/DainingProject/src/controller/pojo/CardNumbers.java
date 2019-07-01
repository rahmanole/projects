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
public class CardNumbers {
    private int id;
    private int cardNo;
    private String status="Inactive";

    public CardNumbers(int id, int cardNo, String status) {
        this.id = id;
        this.cardNo = cardNo;
        this.status = status;
    }

    public CardNumbers(int cardNo, String status) {
        this.cardNo = cardNo;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    
}
