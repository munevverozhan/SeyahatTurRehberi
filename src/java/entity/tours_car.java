/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author DELL
 */
public class tours_car {

    private int tours_car_id;
    private String car_type;
    private String driver_name;

    public tours_car() {
    }

    public tours_car(int tours_car_id, String car_type, String driver_name) {
        this.tours_car_id = tours_car_id;
        this.car_type = car_type;
        this.driver_name = driver_name;
    }

    public int getTours_car_id() {
        return tours_car_id;
    }

    public void setTours_car_id(int tours_car_id) {
        this.tours_car_id = tours_car_id;
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

}
