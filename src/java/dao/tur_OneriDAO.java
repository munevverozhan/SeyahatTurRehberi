/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.tur_Oneri;
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
public class tur_OneriDAO extends DBConnection {

    /* public void update(tur_Oneri c) {
        try {
            Connection connect = this.connect();
            Statement st = connect.createStatement();
            String query = "update admins set mail='" + c.getAgreement_date() + "' where  admins_id=" + c.getTur_oneri_id();
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
     */
    public List<tur_Oneri> getTur_OneriList() {
        List<tur_Oneri> tur_OneriList = new ArrayList<>();
        try {
            Connection connect = this.connect();
            Statement st = connect.createStatement();
            String query = "select * from tur_Oneri";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                tur_OneriList.add(new tur_Oneri(rs.getInt("tur_oneri_id")));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tur_OneriList;
    }
}
