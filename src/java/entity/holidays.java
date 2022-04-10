/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class holidays {

    private int holidays_id;
    private int type_id;
    private Date holidays_date;

    public holidays() {
    }
    
    

    public holidays(int holidays_id, int type_id, Date holidays_date) {
        this.holidays_id = holidays_id;
        this.type_id = type_id;
        this.holidays_date = holidays_date;
    }

    public int getHolidays_id() {
        return holidays_id;
    }

    public void setHolidays_id(int holidays_id) {
        this.holidays_id = holidays_id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public Date getHolidays_date() {
        return holidays_date;
    }

    public void setHolidays_date(Date holidays_date) {
        this.holidays_date = holidays_date;
    }
}
