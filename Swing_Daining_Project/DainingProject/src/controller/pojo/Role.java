/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.pojo;

/**
 *
 * @author Student J2ee-37
 */
public class Role {
    private int id;
    private String email;
    private String roleNmae;
    private String pin;

    public Role(int id, String email, String roleNmae, String pin) {
        this.id = id;
        this.email = email;
        this.roleNmae = roleNmae;
        this.pin = pin;
    }

    public Role(String email, String roleNmae, String pin) {
        this.email = email;
        this.roleNmae = roleNmae;
        this.pin = pin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoleNmae() {
        return roleNmae;
    }

    public void setRoleNmae(String roleNmae) {
        this.roleNmae = roleNmae;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
    
    
    
}
