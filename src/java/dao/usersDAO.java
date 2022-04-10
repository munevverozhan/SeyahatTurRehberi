/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.users;
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
public class usersDAO extends DBConnection{
      public String createUsers(users c) {
        try {
            Connection connect = this.connect();
            Statement st = connect.createStatement();
            String query = "insert into users(mail,passwords,firstname,lastname) values('" + c.getMail() + "', '" + c.getPassword()+ "','" + c.getFirst_name()+ "','" + c.getLast_name()+ "')";
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "index";
    }

    public void delete(users c) {
        try {
            Connection connect = this.connect();
            Statement st = connect.createStatement();
            String query = "delete from users where users_is_id=" + c.getUsers_id();
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(users c) {
        try {
            Connection connect = this.connect();
            Statement st = connect.createStatement();
            String query = "update users set mail='" + c.getMail() + "',passwords='" + c.getPassword()+"'firstname='" + c.getLast_name()+ "' where  users_id=" + c.getUsers_id();
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<users> getUsersList() {
        List<users> usersList = new ArrayList<>();
        try {
            Connection connect = this.connect();
            Statement st = connect.createStatement();
            String query = "select * from users";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                usersList.add(new users(rs.getInt("users_id"), rs.getString("mail"), rs.getString("passwords"), rs.getString("firstname"), rs.getString("lastname")));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return usersList;
    }

}

