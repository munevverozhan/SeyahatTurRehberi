/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.proposalDAO;
import entity.proposal;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author serpl
 */
@FacesConverter("proposalConverter")
public class ProposalConverter implements Converter{
    private proposalDAO proposalDao;
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int proposal_id= Integer.valueOf(string);
        proposal c=this.getProposalDao().findByID(proposal_id);
        return c;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        proposal c=(proposal)t;
        return String.valueOf(c.getProposal_id());
    }

    public proposalDAO getProposalDao() {
         if(proposalDao==null){
            this.proposalDao=new proposalDAO();
        }   
        return proposalDao;
    }

    public void setProposalDao(proposalDAO proposalDao) {
        this.proposalDao = proposalDao;
    }
    
}
