/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.hotels;
import util.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;
/**
 *
 * @author serpl
 */
public class hotelsDAO extends DBConnection {
    
    private usersDAO usersDAO;

    public String createHotels(hotels c) {
        try {
            Connection connect = this.connect();
            Statement st = connect.createStatement();
            String query = "insert into hotels(hotel_id,date,hotel_area,users_id) values('" + c.getHotel_date()+ "', '" + c.getHotel_area()+ "', '" + c.getUser_id()+ "')";
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "index";
    }

    public void delete(hotels c) {
        try {
            Connection connect = this.connect();
            Statement st = connect.createStatement();
            String query = "delete from hotels where hotels_is_id=" + c.getHotels_id();
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

     public void update(hotels c) {
        try {
            Connection connect = this.connect();
            Statement st = connect.createStatement();
            String query = "update users set hotel_date='" + c.getHotel_date() + "'hotel_area='" + c.getHotel_area() + " users_id='" + c.getUser_id()+  "' where  hotels_id="+ c.getHotels_id();
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<hotels> getHotelsList() {
        List<hotels> hotelsList = new ArrayList<>();
        try {
            Connection connect = this.connect();
            Statement st = connect.createStatement();
            String query = "select * from hotels";
            ResultSet rs = st.executeQuery(query);
             while (rs.next()) {
                hotelsList.add(new hotels(rs.getInt("hotels_id"),rs.getDate("hotel_date"), rs.getString("hotel_area"), rs.getInt("users_id")));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return hotelsList;
    }

}

