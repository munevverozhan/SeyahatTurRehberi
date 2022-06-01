/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.hotels;
import entity.tours_car;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author munevver
 */
public class tours_carDAO extends DBConnection {

    private hotelsDAO hotelsDao;

    public void create(tours_car c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "insert into tours_car(car_type,driver_name,hotels_id) values('" + c.getCar_type() + "','" + c.getDriver_name() + "'," + c.getHotel().getHotels_id() + ")";
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(tours_car c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "delete from tours_car where tours_car_id=" + c.getTours_car_id();
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(tours_car c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "update tours_car set car_type='" + c.getCar_type() + "',driver_name='" + c.getDriver_name() + "',hotels_id=" + c.getHotel().getHotels_id() + " where tours_car_id=" + c.getTours_car_id();
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<tours_car> getTours_carList(int page, int pageSize) {
        List<tours_car> tours_carList = new ArrayList<>();

        int start = (page - 1) * pageSize;
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from tours_car order by tours_car_id asc limit " + pageSize + " offset " + start;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                hotels h = this.getHotelsDao().findByID(rs.getInt("hotels_id"));
                tours_carList.add(new tours_car(rs.getInt("tours_car_id"), rs.getString("car_type"), rs.getString("driver_name"), h));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tours_carList;
    }

    public int count() {
        int count = 0;
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select count(tours_car_id) as tours_car_id_count from tours_car ";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            count = rs.getInt("tours_car_id_count");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public hotelsDAO getHotelsDao() {
        if (hotelsDao == null) {
            this.hotelsDao = new hotelsDAO();
        }
        return hotelsDao;
    }

    public void setHotelsDao(hotelsDAO hotelsDao) {
        this.hotelsDao = hotelsDao;
    }

}
