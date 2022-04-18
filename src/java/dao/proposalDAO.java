/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.proposal;
import java.sql.Statement;
import util.DBConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class proposalDAO extends DBConnection {
    public proposal findByID(int proposal_id) {
        proposal c = null;
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from proposal where proposal_id=" + proposal_id;

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                c = (new proposal(rs.getInt("proposal_id"), rs.getString("proposal_name"), rs.getString("context")));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;

    }


    public void create(proposal c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "insert into proposal(proposal_name,context) values('" + c.getProposal_name() + "','"+c.getContext()+"')";
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    public void delete(proposal c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "delete from proposal where proposal_id=" + c.getProposal_id();
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(proposal c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "update proposal set proposal_name='" + c.getProposal_name() + "',context='"+c.getContext()+"' where proposal_id=" + c.getProposal_id();
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<proposal> getProposalList() {
        List<proposal> proposalList = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from proposal order by proposal_id asc";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                proposalList.add(new proposal(rs.getInt("proposal_id"), rs.getString("proposal_name"),rs.getString("context")));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return proposalList;
    }
}
