/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.adminsDAO;
import dao.tur_OneriDAO;
import entity.admins;
import entity.tur_Oneri;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author munevver
 */
@Named(value = "tur_OneriBean")
@SessionScoped
public class tur_OneriBean implements Serializable {

    /**
     * Creates a new instance of tur_OneriBean
     */
    public tur_OneriBean() {
    }

    private tur_Oneri entity;
    private tur_OneriDAO dao;
    private List<tur_Oneri> list;

    public tur_Oneri getEntity() {
        return entity;
    }

    public void setEntity(tur_Oneri entity) {
        this.entity = entity;
    }

    public tur_OneriDAO getDao() {
        return dao;
    }

    public void setDao(tur_OneriDAO dao) {
        this.dao = dao;
    }

    public List<tur_Oneri> getList() {
        return list;
    }

    public void setList(List<tur_Oneri> list) {
        this.list = list;
    }


    /*
    public void update() {
        this.getDao().update(this.entity);
        this.entity = new tur_Oneri();
    }
     */
}
