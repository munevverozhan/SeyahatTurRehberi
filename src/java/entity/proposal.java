/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;

/**
 *
 * @author serpl
 */
public class proposal {

    private int proposal_id;
    private String proposal_name;
    private String context;

    public proposal() {
    }

    public proposal(int proposal_id, String proposal_name, String context) {
        this.proposal_id = proposal_id;
        this.proposal_name = proposal_name;
        this.context = context;
    }

   

    public int getProposal_id() {
        return proposal_id;
    }

    public void setProposal_id(int proposal_id) {
        this.proposal_id = proposal_id;
    }

    public String getProposal_name() {
        return proposal_name;
    }

    public void setProposal_name(String proposal_name) {
        this.proposal_name = proposal_name;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.proposal_id;
        hash = 53 * hash + Objects.hashCode(this.proposal_name);
        hash = 53 * hash + Objects.hashCode(this.context);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final proposal other = (proposal) obj;
        if (this.proposal_id != other.proposal_id) {
            return false;
        }
        if (!Objects.equals(this.proposal_name, other.proposal_name)) {
            return false;
        }
        return Objects.equals(this.context, other.context);
    }

  

   

}

   