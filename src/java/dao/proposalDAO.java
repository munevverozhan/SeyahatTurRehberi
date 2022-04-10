/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.proposal;
import java.sql.Statement;
import util.DBConnection;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author aysetunc
 */

    public class proposalDAO extends DBConnection {

    public String createProposal(proposal c) {
        try {
            Connection connect = this.connect();
            Statement st = connect.createStatement();
            String query = "insert into proposal(type_id) values('" + c.getProposal_id() + "')";
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "index";
    }

    public void delete(proposal c) {
        try {
            Connection connect = this.connect();
            Statement st = connect.createStatement();
            String query ="delete proposal where proposal_id="+c.getProposal_id();
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(proposal c) {
        try {
            Connection connect = this.connect();
            Statement st = connect.createStatement();
            String query ="update proposal set type_id='"+c.getType_id()+"' where propsal_id="+c.getProposal_id();
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<proposal> getProposalList() {
        List<proposal> proposalList = new ArrayList<>();
        try {
            Connection connect = this.connect();
            Statement st = connect.createStatement();
            String query = "select * from proposal";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                proposalList.add(new proposal(rs.getInt("proposal_id"),rs.getInt("type_id")));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return proposalList;
    }
}

    

