/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.agreement;
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
public class agreementDAO extends DBConnection {

    public String createAgreement(agreement c) {
        try {
            Connection connect = this.connect();
            Statement st = connect.createStatement();
            String query = "insert into agreement(agreement_date) values('" + c.getAgreement_date() + "')";
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "index";
    }

    public void delete(agreement c) {
        try {
            Connection connect = this.connect();
            Statement st = connect.createStatement();
            String query = "delete from agreement where agreement_id=" + c.getAgreement_id();
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(agreement c) {
        try {
            Connection connect = this.connect();
            Statement st = connect.createStatement();
            String query = "update agreement set agreement_date='" + c.getAgreement_date() + "' where  agreement_id=" + c.getAgreement_id();
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<agreement> getAgreementList() {
        List<agreement> agreementList = new ArrayList<>();
        try {
            Connection connect = this.connect();
            Statement st = connect.createStatement();
            String query = "select * from agreement";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                agreementList.add(new agreement(rs.getInt("agreement_id"), rs.getDate("agreement_date")));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return agreementList;
    }
}
