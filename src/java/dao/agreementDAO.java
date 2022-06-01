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
import java.sql.PreparedStatement;

/**
 *
 * @author
 */
public class agreementDAO extends DBConnection {

    private usersDAO usersDao;

    public void create(agreement c) {
        try {

            PreparedStatement pst = this.getConnection().prepareStatement("insert into agreement(name,agreement_date,users_id) values (?,?,?)");
            pst.setString(1, c.getName());
            pst.setString(2, c.getAgreement_date());
            pst.setInt(3, c.getUsers().getUsers_id());
            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(agreement c) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from agreement where agreement_id=?");
            pst.setInt(1, c.getAgreement_id());
            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(agreement c) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update agreement set name=?,agreement_date=? ,users_id=? where  agreement_id=?");
            pst.setString(1, c.getName());
            pst.setString(2, c.getAgreement_date());
            pst.setInt(3, c.getUsers().getUsers_id());
            pst.setInt(4, c.getAgreement_id());
            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<agreement> getAgreementList(int page, int pageSize) {
        List<agreement> agreementList = new ArrayList<>();
        agreement obj;
        int start = (page - 1) * pageSize;

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from agreement order by agreement_id asc limit " + pageSize + " offset " + start);
            ResultSet rs = pst.executeQuery();
            //    Statement st = this.getConnection().createStatement();

            //  String query = "select * from agreement order by agreement_id asc";
            //ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new agreement();
                obj.setAgreement_id(rs.getInt("agreement_id"));
                obj.setName(rs.getString("name"));
                obj.setAgreement_date(rs.getString("agreement_date"));
                obj.setUsers(this.getUsersDao().findByID(rs.getInt("users_id")));
                agreementList.add(obj);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return agreementList;
    }

    public int count() {
        int count = 0;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select count(agreement_id) as agreement_count from agreement  ");
            ResultSet rs = pst.executeQuery();
            //    Statement st = this.getConnection().createStatement();

            //  String query = "select * from agreement order by agreement_id asc";
            rs.next();
            count = rs.getInt("agreement_count");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
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
