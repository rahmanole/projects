/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.pojo;

public class PersonalInfo {
    private int id;
    private String name;
    private String contNum;
    private String email;
    private String deptName;
    private String regNum;
    private String session;

    public PersonalInfo(int id, String name, String contNum, String email, String deptName, String regNum, String session) {
        this.id = id;
        this.name = name;
        this.contNum = contNum;
        this.email = email;
        this.deptName = deptName;
        this.regNum = regNum;
        this.session = session;
    }

    public PersonalInfo(String name, String contNum, String email, String deptName, String regNum, String session) {
        this.name = name;
        this.contNum = contNum;
        this.email = email;
        this.deptName = deptName;
        this.regNum = regNum;
        this.session = session;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContNum() {
        return contNum;
    }

    public void setContNum(String contNum) {
        this.contNum = contNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }



    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    


    
    
    
}
