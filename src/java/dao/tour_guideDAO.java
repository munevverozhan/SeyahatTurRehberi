/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.holidays;
import entity.proposal;
import entity.tour_guide;
import java.sql.Statement;
import util.DBConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author serpl
 */
public class tour_guideDAO extends DBConnection {

    private proposalDAO proposalDao;
    private holidaysDAO holidaysDao;

    public void create(tour_guide c) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into tour_guide(guide_name,guide_language,holidays_id) values('" + c.getGuide_name() + "','" + c.getGuide_language() + "'," + c.getHolidays().getHolidays_id() + ")";
            st.executeUpdate(query);
         
            ResultSet rs = st.executeQuery("select max(tour_guide_id) as mid from tour_guide");
            rs.next();
            int tour_guide_id = rs.getInt("mid");

            for (proposal prop : c.getProp()) {
                query = "insert into tur_oneri(tour_guide_id,proposal_id) values(" + tour_guide_id + "," + prop.getProposal_id() + ")";
                st.executeUpdate(query);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(tour_guide c) {
        try {
            Statement st = this.getConnection().createStatement();

            st.executeUpdate("delete from tur_oneri where tour_guide_id=" + c.getTour_guide_id());

            String query = "delete from tour_guide where tour_guide_id=" + c.getTour_guide_id();
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(tour_guide c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "update tour_guide set guide_name='" + c.getGuide_name() + "',guide_language='" + c.getGuide_language() + "',holidays_id="+c.getHolidays().getHolidays_id()+" where tour_guide_id=" + c.getTour_guide_id();
            st.executeUpdate(query);
            st.executeUpdate("delete from tur_oneri where tour_guide_id=" + c.getTour_guide_id());
            for (proposal prop : c.getProp()) {
                query = "insert into tur_oneri(tour_guide_id,proposal_id) values(" + c.getTour_guide_id() + "," + prop.getProposal_id() + ")";
                st.executeUpdate(query);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<tour_guide> getTour_guideList() {
        List<tour_guide> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from tour_guide order by tour_guide_id asc ";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                holidays u = this.getHolidaysDao().findByID(rs.getInt("holidays_id"));
                list.add(new tour_guide(rs.getInt("tour_guide_id"), rs.getString("guide_name"), rs.getString("guide_language"), this.getTourProposal(rs.getInt("tour_guide_id")),u));
            }
         
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public List<proposal> getTourProposal(int tour_guide_id) {
        List<proposal> proposalList = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from proposal where proposal_id in(select proposal_id from tur_oneri where tour_guide_id=" + tour_guide_id + ")";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                proposalList.add(new proposal(rs.getInt("proposal_id"), rs.getString("proposal_name"), rs.getString("context")));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return proposalList;
    }

    public proposalDAO getProposalDao() {
        if (proposalDao == null) {
            this.proposalDao = new proposalDAO();
        }
        return proposalDao;
    }

    public void setProposalDao(proposalDAO proposalDao) {
        this.proposalDao = proposalDao;
    }

    public holidaysDAO getHolidaysDao() {
        if (holidaysDao == null) {
            this.holidaysDao = new holidaysDAO();
        }
        return holidaysDao;
    }

    public void setHolidaysDao(holidaysDAO holidaysDao) {
        this.holidaysDao = holidaysDao;
    }

   
 

}
