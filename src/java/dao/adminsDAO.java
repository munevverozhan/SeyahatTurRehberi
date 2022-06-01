/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.admins;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;
import java.sql.PreparedStatement;

/**
 *
 * @author
 */
public class adminsDAO extends DBConnection {

    public String createAdmins(admins c) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into admins(mail,passwords) values (?,?)", Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, c.getMail());
            pst.setString(2, c.getPasswords());
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();

            //     Statement st = this.getConnection().createStatement();
            //     String query = "insert into admins(mail,passwords) values('" + c.getMail() + "', '" + c.getPasswords() + "')";
            //     int r = st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "index";
    }

    public void delete(admins c) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from admins where admins_id= ?", Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, c.getAdmins_id());
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();

            //   Statement st = this.getConnection().createStatement();
            //   String query = "delete from admins where admins_id=" + c.getAdmins_id();
            //   int r = st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(admins c) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update admins set mail= ? ,passwords=?  where  admins_id=?", Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, c.getMail());
            pst.setString(2, c.getPasswords());
            pst.setInt(3, c.getAdmins_id());
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();

            //  Statement st = this.getConnection().createStatement();
            //  String query = "update admins set mail='" + c.getMail() + "',passwords='" + c.getPasswords() + "' where  admins_id=" + c.getAdmins_id();
            //  int r = st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<admins> getAdminsList(int page, int pageSize) {
        List<admins> adminsList = new ArrayList<>();
        admins obj;
        int start = (page - 1) * pageSize;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from admins order by admins_id asc limit " + pageSize + " offset " + start);

            ResultSet rs = pst.executeQuery();

            //    Statement st = this.getConnection().createStatement();
            //    String query = "select * from admins";c 
            //    ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new admins();
                obj.setAdmins_id(rs.getInt("admins_id"));
                obj.setMail(rs.getString("mail"));
                obj.setPasswords(rs.getString("passwords"));
                adminsList.add(obj);
                //    adminsList.add(new admins(rs.getInt("admins_id"), rs.getString("mail"), rs.getString("passwords")));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return adminsList;
    }

    public int count() {
        int count = 0;

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select count(admins_id) as admins_count from admins");

            ResultSet rs = pst.executeQuery();

            //    Statement st = this.getConnection().createStatement();
            //    String query = "select * from admins";
            //    ResultSet rs = st.executeQuery(query);
            rs.next();
            count = rs.getInt("admins_count");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

}
