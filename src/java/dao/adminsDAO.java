/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.admins;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author munevver
 */
public class adminsDAO extends DBConnection {

    public String createAdmins(admins c) {
        try {
            Connection connect = this.connect();
            Statement st = connect.createStatement();
            String query = "insert into admins(mail,passwords) values('" + c.getMail() + "', '" + c.getPasswords() + "')";
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "index";
    }

    public void delete(admins c) {
        try {
            Connection connect = this.connect();
            Statement st = connect.createStatement();
            String query = "delete from admins where admins_id=" + c.getAdmins_id();
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(admins c) {
        try {
            Connection connect = this.connect();
            Statement st = connect.createStatement();
            String query = "update admins set mail='" + c.getMail() + "',passwords='" + c.getPasswords() + "' where  admins_id=" + c.getAdmins_id();
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<admins> getAdminsList() {
        List<admins> adminsList = new ArrayList<>();
        try {
            Connection connect = this.connect();
            Statement st = connect.createStatement();
            String query = "select * from admins";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                adminsList.add(new admins(rs.getInt("admins_id"), rs.getString("mail"), rs.getString("passwords")));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return adminsList;
    }

}
