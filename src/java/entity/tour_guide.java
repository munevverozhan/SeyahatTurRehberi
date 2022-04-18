/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.List;

/**
 *
 * @author serpl
 */
public class tour_guide {

    private int tour_guide_id;
    private String guide_name;
    private String guide_language;
    private List<proposal> prop;
    private holidays holidays;
    
    public tour_guide() {
    }

    public tour_guide(int tour_guide_id, String guide_name, String guide_language, List<proposal> prop) {
        this.tour_guide_id = tour_guide_id;
        this.guide_name = guide_name;
        this.guide_language = guide_language;
        this.prop = prop;
    }

    public tour_guide(int tour_guide_id, String guide_name, String guide_language, List<proposal> prop, holidays holidays) {
        this.tour_guide_id = tour_guide_id;
        this.guide_name = guide_name;
        this.guide_language = guide_language;
        this.prop = prop;
        this.holidays = holidays;
    }


    public holidays getHolidays() {
        return holidays;
    }

    public void setHolidays(holidays holidays) {
        this.holidays = holidays;
    }

    public int getTour_guide_id() {
        return tour_guide_id;
    }

    public void setTour_guide_id(int tour_guide_id) {
        this.tour_guide_id = tour_guide_id;
    }

    public String getGuide_name() {
        return guide_name;
    }

    public void setGuide_name(String guide_name) {
        this.guide_name = guide_name;
    }

    public String getGuide_language() {
        return guide_language;
    }

    public void setGuide_language(String guide_language) {
        this.guide_language = guide_language;
    }

    public List<proposal> getProp() {
        return prop;
    }

    public void setProp(List<proposal> prop) {
        this.prop = prop;
    }
    

}
