/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.consideration;
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
public class considerationDAO extends DBConnection {

    private usersDAO usersDao;
    public consideration findByID(int consideration_id) {
        consideration c = null;
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from consideration where consideration_id=" + consideration_id;

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                c = (new consideration(rs.getInt("consideration_id"), rs.getString("context")));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;

    }

    public void create(consideration c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "insert into consideration(context) values('" + c.getContext() + "')";
            int r = st.executeUpdate(query);
            ResultSet rs = st.executeQuery("select max(consideration_id) as mid from consideration");
            rs.next();
            int consideration_id = rs.getInt("mid");

            for (users user : c.getUseries()) {
                query = "insert into kullanici_deger(consideration_id,users_id) values(" + consideration_id + "," + user.getUsers_id() + ")";
                st.executeUpdate(query);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(consideration c) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("delete from kullanici_deger where consideration_id=" + c.getConsideration_id());

            String query = "delete from consideration where consideration_id=" + c.getConsideration_id();
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(consideration c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "update consideration set context='" + c.getContext() + "' where consideration_id=" + c.getConsideration_id();
            st.executeUpdate(query);
            st.executeUpdate("delete from kullanici_deger where consideration_id=" + c.getConsideration_id());
            for (users user : c.getUseries()) {
                query = "insert into kullanici_deger(consideration_id,users_id) values(" + c.getConsideration_id() + "," + user.getUsers_id() + ")";
                st.executeUpdate(query);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public List<consideration> getConsiderationList() {
        List<consideration> considerationList = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from consideration order by consideration_id asc";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                considerationList.add(new consideration(rs.getInt("consideration_id"), rs.getString("context"),this.getConsiderationUser(rs.getInt("consideration_id"))));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return considerationList;
    }
     public List<users> getConsiderationUser(int consideration_id) {
        List<users> usersList = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from users where users_id in(select users_id from kullanici_deger where consideration_id=" + consideration_id + ")";
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
