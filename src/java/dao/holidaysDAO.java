/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.holidays;
import entity.users;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author aysetunc
 */
public class holidaysDAO extends DBConnection {

    private usersDAO usersDao;

    public holidays findByID(int holidays_id) {
        holidays c = null;
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from holidays where holidays_id=" + holidays_id;

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                c = (new holidays(rs.getInt("holidays_id"), rs.getString("holiday_name"), rs.getString("holiday_date")));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;

    }
    public void createHolidays(holidays c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "insert into holidays(holiday_name,holiday_date) values('" + c.getHoliday_name() + "','" + c.getHoliday_date() + "')";
            int r = st.executeUpdate(query);
            ResultSet rs = st.executeQuery("select max(holidays_id) as mid from holidays");
            rs.next();
            int holidays_id = rs.getInt("mid");

            for (users user : c.getUseries()) {
                query = "insert into kullanici_tatil(holidays_id,users_id) values(" + holidays_id + "," + user.getUsers_id() + ")";
                st.executeUpdate(query);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(holidays c) {
        try {
            Statement st = this.getConnection().createStatement();

            st.executeUpdate("delete from kullanici_tatil where holidays_id=" + c.getHolidays_id());

            String query = "delete from holidays where holidays_id=" + c.getHolidays_id();
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(holidays c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "update holidays set holiday_name='" + c.getHoliday_name() + "', holiday_date='" + c.getHoliday_date() + "' where holidays_id=" + c.getHolidays_id();
            st.executeUpdate(query);
            st.executeUpdate("delete from kullanici_tatil where holidays_id=" + c.getHolidays_id());
            for (users user : c.getUseries()) {
                query = "insert into kullanici_tatil(holidays_id,users_id) values(" + c.getHolidays_id() + "," + user.getUsers_id() + ")";
                st.executeUpdate(query);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<holidays> getHolidaysList() {
        List<holidays> holidaysList = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from holidays order by holidays_id asc ";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                holidaysList.add(new holidays(rs.getInt("holidays_id"), rs.getString("holiday_name"), rs.getString("holiday_date"), this.getHolidaysUseries(rs.getInt("holidays_id"))));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return holidaysList;
    }

    public List<users> getHolidaysUseries(int holidays_id) {
        List<users> usersList = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from users where users_id in(select users_id from kullanici_tatil where holidays_id=" + holidays_id + ")";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                usersList.add(new users(rs.getInt("users_id"), rs.getString("mail"), rs.getString("passwords"), rs.getString("first_name"), rs.getString("last_name")));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return usersList;
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
