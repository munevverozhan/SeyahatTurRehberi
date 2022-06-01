/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.users;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author munevver
 */
public class usersDAO extends DBConnection {

    public users findByID(int users_id) {
        users c = null;
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from users where users_id=" + users_id;

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                c = (new users(rs.getInt("users_id"), rs.getString("mail"), rs.getString("passwords"), rs.getString("first_name"), rs.getString("last_name")));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;

    }

    public void createUsers(users c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "insert into users(mail,passwords,first_name,last_name) values('" + c.getMail() + "', '" + c.getPasswords() + "','" + c.getFirst_name() + "','" + c.getLast_name() + "')";
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(users c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "delete from users where users_id=" + c.getUsers_id();
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(users c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "update users set mail='" + c.getMail() + "',passwords='" + c.getPasswords() + "',first_name='" + c.getFirst_name() + "',last_name='" + c.getLast_name() + "' where  users_id=" + c.getUsers_id();
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<users> getUsersList(int page, int pageSize) {
        List<users> usersList = new ArrayList<>();

        int start = (page - 1) * pageSize;
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from users order by users_id asc limit " + pageSize + " offset " + start;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                usersList.add(new users(rs.getInt("users_id"), rs.getString("mail"), rs.getString("passwords"), rs.getString("first_name"), rs.getString("last_name")));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return usersList;
    }

    public int count() {
        int count = 0;
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select count(users_id) as users_count from users ";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            count = rs.getInt("users_count");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

}
