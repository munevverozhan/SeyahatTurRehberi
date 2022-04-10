/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import entity.consideration;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author DEll
 */
public class considerationDAO extends DBConnection
{
     

    public void delete(consideration c) {
        try {
            Connection connect = this.connect();
            Statement st = connect.createStatement();
            String query = "delete from consideration where consideration_id=" + c.getConsideration_id();
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

   

    public List<consideration> getConsiderationList() {
        List<consideration> considerationList = new ArrayList<>();
        try {
            Connection connect = this.connect();
            Statement st = connect.createStatement();
            String query = "select * from consideration";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                considerationList.add(new consideration(rs.getInt("consideration_id")));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return considerationList;
    }
}

