/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.considerationDAO;
import entity.consideration;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author DELL
 */
@Named(value = "considerationBean")
@SessionScoped
public class considerationBean implements Serializable {

    /**
     * Creates a new instance of considerationBean
     */
    public considerationBean() {

    }
    private consideration entity;
    private considerationDAO dao;
    private List<consideration> list;

    public consideration getEntity() {
        if (this.entity == null) {
            this.entity = new consideration();

        }
        return entity;
    }

    public void setEntity(consideration entity) {
        this.entity = entity;
    }

    public considerationDAO getDao() {
        if (this.dao == null) {
            this.dao = new considerationDAO();
        }
        return dao;
    }

    public void setDao(considerationDAO dao) {
        this.dao = dao;
    }

    public List<consideration> getList() {
        this.list = this.getDao().getConsiderationList();
        return list;
    }

    public void setList(List<consideration> list) {
        this.list = list;
    }

    public void delete(consideration c) {
        this.getDao().delete(c);
    }

}
