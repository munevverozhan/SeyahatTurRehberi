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

public class agreement {
    private int agreement_id;
    private Date agreement_date;

    public agreement() {
    }

    public agreement(int agreement_id, Date agreement_date) {
        this.agreement_id = agreement_id;
        this.agreement_date = agreement_date;
    }
    

    public int getAgreement_id() {
        return agreement_id;
    }

    public void setAgreement_id(int agreement_id) {
        this.agreement_id = agreement_id;
    }

    public Date getAgreement_date() {
        return agreement_date;
    }

    public void setAgreement_date(Date agreement_date) {
        this.agreement_date = agreement_date;
    }
}
