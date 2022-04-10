/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author aysetunc
 */
public class tour_guide {

    private int tour_guide_id;
    private String guide_name;
    private String guide_language;

    public tour_guide() {
    }

    public tour_guide(int tour_guide_id, String guide_name, String guide_language) {
        this.tour_guide_id = tour_guide_id;
        this.guide_name = guide_name;
        this.guide_language = guide_language;
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

}
