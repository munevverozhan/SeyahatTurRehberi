/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.proposalDAO;
import entity.proposal;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author aysetunc
 */
@Named(value = "proposalBean")
@SessionScoped

/**
 * Creates a new instance of proposalBean
 */
public class proposalBean implements Serializable {


    /**
     * Creates a new instance of proposalBean
     */
    public proposalBean() {
    }
    private proposal entity;
    private proposalDAO dao;
    private List<proposal> list;

    public proposal getEntity() {
        if (this.entity == null) {
            this.entity = new proposal();
        }
        return entity;
    }

    public void setEntity(proposal entity) {
        this.entity = entity;
    }

    public proposalDAO getDao() {
        if (this.dao == null) {
            this.dao = new proposalDAO();
        }
        return dao;
    }

    public void setDao(proposalDAO dao) {
        this.dao = dao;
    }

    public List<proposal> getList() {
        this.list = this.getDao().getProposalList();
        return list;
    }

    public void setList(List<proposal> list) {
        this.list = list;
    }

    public String create() {

        this.getDao().createProposal(entity);
        this.entity = new proposal();
        return "index";
    }

    public void delete(proposal c) {
        this.getDao().delete(c);
    }

    public void update() {
        this.getDao().update(this.entity);
        this.entity = new proposal();
    }

}

    

