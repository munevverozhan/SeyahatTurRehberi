/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.consideration;
import entity.hotels;
import entity.users;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author DELL
 */
public class hotelsDAO extends DBConnection {

    private considerationDAO considerationDao;
    private usersDAO usersDao;

    public hotels findByID(int hotels_id) {
        hotels c = null;
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from hotels where hotels_id=" + hotels_id;

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                c = (new hotels(rs.getInt("hotels_id"), rs.getString("hotel_date"), rs.getString("hotel_area")));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;

    }

    public void create(hotels c) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into hotels(hotel_date,hotel_area,users_id) values('" + c.getHotel_date() + "', '" + c.getHotel_area() + "'," + c.getUsers().getUsers_id() + " )";
            st.executeUpdate(query);
            ResultSet rs = st.executeQuery("select max(hotels_id) as mid from hotels");
            rs.next();
            int hotels_id = rs.getInt("mid");

            for (consideration cons : c.getCons()) {
                query = "insert into otel_yorum(hotels_id,consideration_id) values(" + hotels_id + "," + cons.getConsideration_id() + ")";
                st.executeUpdate(query);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(hotels c) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("delete from otel_yorum where hotels_id=" + c.getHotels_id());

            String query = "delete from hotels where hotels_id=" + c.getHotels_id();
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(hotels c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "update hotels set hotel_date='" + c.getHotel_date() + "',hotel_area='" + c.getHotel_area() + "',users_id=" + c.getUsers().getUsers_id() + " where  hotels_id=" + c.getHotels_id();
            st.executeUpdate(query);
            st.executeUpdate("delete from otel_yorum where hotels_id=" + c.getHotels_id());

            for (consideration cons : c.getCons()) {
                query = "insert into otel_yorum(hotels_id,consideration_id) values(" + c.getHotels_id() + "," + cons.getConsideration_id() + ")";
                st.executeUpdate(query);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<hotels> getHotelsList(int page, int pageSize) {
        List<hotels> hotelsList = new ArrayList<>();
        int start = (page - 1) * pageSize;

        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from hotels order by hotels_id asc limit " + pageSize + " offset " + start;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                users u = this.getUsersDao().findByID(rs.getInt("users_id"));
                hotelsList.add(new hotels(rs.getInt("hotels_id"), rs.getString("hotel_date"), rs.getString("hotel_area"), this.getConsiderationHotels(rs.getInt("hotels_id")), u));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return hotelsList;
    }

    public int count() {
        int count = 0;
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select count(hotels_id) as hotels_count from hotels";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            count = rs.getInt("hotels_count");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public List<consideration> getConsiderationHotels(int hotels_id) {
        List<consideration> considerationList = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from consideration where consideration_id in(select consideration_id from otel_yorum where hotels_id=" + hotels_id + ")";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                considerationList.add(new consideration(rs.getInt("consideration_id"), rs.getString("context")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return considerationList;
    }

    public considerationDAO getConsiderationDao() {
        if (considerationDao == null) {
            this.considerationDao = new considerationDAO();
        }
        return considerationDao;
    }

    public void setConsiderationDao(considerationDAO considerationDao) {
        this.considerationDao = considerationDao;
    }

    public usersDAO getUsersDao() {
        if (usersDao == null) {
            this.usersDao = new usersDAO();
        }
        return usersDao;
    }

    public void setUsersDao(usersDAO usersDao) {
        this.usersDao = usersDao;
    }

}
