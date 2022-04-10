/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import entity.holidays;
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
public class holidaysDAO extends DBConnection {
    
    
       public String createHolidays(holidays c) {
        try {
            Connection connect = this.connect();
            Statement st = connect.createStatement();
            String query = "insert into holidays(type_id,holidays_date) values('" + c.getHolidays_date() + "')";
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "index";
    }

    public void delete(holidays c) {
        try {
            Connection connect = this.connect();
            Statement st = connect.createStatement();
            String query = "delete from holidays where holidays_id=" + c.getHolidays_id();
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(holidays c) {
        try {
            Connection connect = this.connect();
            Statement st = connect.createStatement();
            String query = "update holidays set type_id='" + c.getType_id() + "' where holidays_date=" + c.getHolidays_date();
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<holidays> getHolidaysList() {
        List<holidays> holidaysList = new ArrayList<>();
        try {
            Connection connect = this.connect();
            Statement st = connect.createStatement();
            String query = "select * from holidays";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                holidaysList.add(new holidays(rs.getInt("type_id"), rs.getDate("holidays_date")));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return holidaysList;
    }
}

    

