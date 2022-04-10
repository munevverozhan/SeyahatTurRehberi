/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.holidays;
import entity.tours_car;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author DELL
 */
public class tours_carDAO extends DBConnection {
    
     public String createTours_car(tours_car c) {
        try {
            Connection connect = this.connect();
            Statement st = connect.createStatement();
            String query = "insert into tours_car(car_type,driver_name) values('" + c.getCar_type() + "')";
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "index";
    }

    public void delete(tours_car c) {
        try {
            Connection connect = this.connect();
            Statement st = connect.createStatement();
            String query = "delete from tours_car where tours_car_id=" + c.getTours_car_id();
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(tours_car c) {
        try {
            Connection connect = this.connect();
            Statement st = connect.createStatement();
            String query = "update tours_car set tours_car_id='" + c.getTours_car_id() + "' where car_type=" + c.getCar_type();
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<tours_car> getTours_carList() {
        List<tours_car> tours_carList = new ArrayList<>();
        try {
            Connection connect = this.connect();
            Statement st = connect.createStatement();
            String query = "select * from tours_car";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                tours_carList.add(new tours_car(rs.getInt("tours_car_id"), rs.getString("car_type"),rs.getString("driver_name")));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tours_carList;
    }
    
}
