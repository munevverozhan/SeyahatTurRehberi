/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.tours_carDAO;
import entity.tours_car;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author DELL
 */
@Named(value = "tours_carBean")
@SessionScoped
public class tours_carBean implements Serializable {

    /**
     * Creates a new instance of tours_carBean
     */
    public tours_carBean() {
    }
    private tours_car entity;
    private tours_carDAO dao;
    private List<tours_car> list;

    public tours_car getEntity() {
        if (this.entity == null) {
            this.entity = new tours_car();

        }
        return entity;
    }

    public void setEntity(tours_car entity) {
        this.entity = entity;
    }

    public tours_carDAO getDao() {
        if (this.dao == null) {
            this.dao = new tours_carDAO();
        }
        return dao;
    }

    public void setDao(tours_carDAO dao) {
        this.dao = dao;
    }

    public List<tours_car> getList() {
        this.list = this.getDao().getTours_carList();
        return list;
    }

    public void setList(List<tours_car> list) {
        this.list = list;
    }

}
