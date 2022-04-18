/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author aysetunc
 */
public class holidays {

    private int holidays_id;
    private String holiday_name;
    private String holiday_date;
    private List<users> useries;

    public holidays() {
    }

    public holidays(int holidays_id, String holiday_name, String holiday_date, List<users> useries) {
        this.holidays_id = holidays_id;
        this.holiday_name = holiday_name;
        this.holiday_date = holiday_date;
        this.useries = useries;
    }

    public holidays(int holidays_id, String holiday_name, String holiday_date) {
        this.holidays_id = holidays_id;
        this.holiday_name = holiday_name;
        this.holiday_date = holiday_date;
    }

    
    public int getHolidays_id() {
        return holidays_id;
    }

    public void setHolidays_id(int holidays_id) {
        this.holidays_id = holidays_id;
    }

    public String getHoliday_name() {
        return holiday_name;
    }

    public void setHoliday_name(String holiday_name) {
        this.holiday_name = holiday_name;
    }

    public String getHoliday_date() {
        return holiday_date;
    }

    public void setHoliday_date(String holiday_date) {
        this.holiday_date = holiday_date;
    }

    public List<users> getUseries() {
        return useries;
    }

    public void setUseries(List<users> useries) {
        this.useries = useries;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.holidays_id;
        hash = 59 * hash + Objects.hashCode(this.holiday_name);
        hash = 59 * hash + Objects.hashCode(this.holiday_date);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final holidays other = (holidays) obj;
        if (this.holidays_id != other.holidays_id) {
            return false;
        }
        if (!Objects.equals(this.holiday_name, other.holiday_name)) {
            return false;
        }
        return Objects.equals(this.holiday_date, other.holiday_date);
    }

  


    

   
}

