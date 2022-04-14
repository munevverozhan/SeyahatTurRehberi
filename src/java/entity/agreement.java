/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author munevver
 */
import java.util.Date;

public class agreement { //anlaşma

    private int agreement_id;
    private String name;
    private String agreement_date;   
    private users users;

    public agreement() {
    }

    public agreement(int agreement_id, String name, String agreement_date, users users) {
        this.agreement_id = agreement_id;
        this.name = name;
        this.agreement_date = agreement_date;
        this.users = users;
    }

    public int getAgreement_id() {
        return agreement_id;
    }

    public void setAgreement_id(int agreement_id) {
        this.agreement_id = agreement_id;
    }

    public String getAgreement_date() {
        return agreement_date;
    }

    public void setAgreement_date(String agreement_date) {
        this.agreement_date = agreement_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public users getUsers() {
        return users;
    }

    public void setUsers(users users) {
        this.users = users;
    }
  
    
}
