/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.hotelsDAO;
import entity.hotels;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
/**
 *
 * @author serpl
 */
@Named(value = "hotelsBean")
@SessionScoped
public class hotelsBean implements Serializable {

    /**
     * Creates a new instance of hotelsBean
     */
    public hotelsBean() {
    }
     private hotels entity;
    private hotelsDAO dao;
    private List<hotels> list;
    public hotels getEntity() {
        if (this.entity == null) {
            this.entity = new hotels();
        }
        return entity;
    }

    public void setEntity(hotels entity) {
        this.entity = entity;
    }

    public hotelsDAO getDao() {
        if (this.dao == null) {
            this.dao = new hotelsDAO();
        }
        return dao;
    }

    public void setDao(hotelsDAO dao) {
        this.dao = dao;
    }

    public List<hotels> getList() {
        this.list = this.getDao().getHotelsList();
        return list;
    }

    public void setList(List<hotels> list) {
        this.list = list;
    }

    public void create() {

        this.getDao().create(entity);
        this.entity = new hotels();
        
    }

    public void delete(hotels c) {
        this.getDao().delete(c);
    }

    public void update() {
        this.getDao().update(this.entity);
        this.entity = new hotels();
    }
}


