/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.agreement;
import entity.users;
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

    private usersDAO usersDao;

    public void create(agreement c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "insert into agreement(name,agreement_date,users_id) values('" + c.getName() + "','" + c.getAgreement_date() + "'," + c.getUsers().getUsers_id() + ")";
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(agreement c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "delete from agreement where agreement_id=" + c.getAgreement_id();
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(agreement c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "update agreement set name='" + c.getName() + "',agreement_date='" + c.getAgreement_date() + "',users_id=" + c.getUsers().getUsers_id() + " where  agreement_id=" + c.getAgreement_id();
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<agreement> getAgreementList() {
        List<agreement> agreementList = new ArrayList<>();
        try {

            Statement st = this.getConnection().createStatement();

            String query = "select * from agreement order by agreement_id asc";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                users u = this.getUsersDao().findByID(rs.getInt("users_id"));
                agreementList.add(new agreement(rs.getInt("agreement_id"), rs.getString("name"), rs.getString("agreement_date"), u));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return agreementList;
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
