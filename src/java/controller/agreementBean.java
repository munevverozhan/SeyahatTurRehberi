/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.agreementDAO;
import entity.agreement;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author munevver
 */
@Named(value = "agreementBean")
@SessionScoped
public class agreementBean implements Serializable {

    /**
     * Creates a new instance of agreementBean
     */
    public agreementBean() {
    }
    private agreement entity;
    private agreementDAO dao;
    private List<agreement> list;

    public agreement getEntity() {
        if (this.entity == null) {
            this.entity = new agreement();
        }
        return entity;
    }

    public void setEntity(agreement entity) {
        this.entity = entity;
    }

    public agreementDAO getDao() {
        if (this.dao == null) {
            this.dao = new agreementDAO();
        }
        return dao;
    }

    public void setDao(agreementDAO dao) {
        this.dao = dao;
    }

    public List<agreement> getList() {
        this.list = this.getDao().getAgreementList();
        return list;
    }

    public void setList(List<agreement> list) {
        this.list = list;
    }

    public void create() {

        this.getDao().create(entity);
        this.entity = new agreement();
        
    }

    public void delete(agreement c) {
        this.getDao().delete(c);
    }

    public void update() {
        this.getDao().update(this.entity);
        this.entity = new agreement();
    }

}
