/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.pojo;

/**
 *
 * @author ccsl-pc
 */
public class Department {
    private int id;
    private String deptName;

    public Department(int id, String deptName) {
        this.id = id;
        this.deptName = deptName;
    }

    public Department(String deptName) {
        this.deptName = deptName;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    
    
    
}
