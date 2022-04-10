/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.holidaysDAO;
import entity.holidays;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author DELL
 */
@Named(value = "holidaysBean")
@SessionScoped
public class holidaysBean implements Serializable {

    /**
     * Creates a new instance of holidaysBean
     */
    public holidaysBean() {
    }

    private holidays entity;
    private holidaysDAO dao;
    private List<holidays> list;

    public holidays getEntity() {
        if (this.entity == null) {
            this.entity = new holidays();
        }
        return entity;
    }

    public void setEntity(holidays entity) {
        this.entity = entity;
    }

    public holidaysDAO getDao() {
        if (this.dao == null) {
            this.dao = new holidaysDAO();
        }
        return dao;
    }

    public void setDao(holidaysDAO dao) {
        this.dao = dao;
    }

    public List<holidays> getList() {
        this.list = this.getDao().getHolidaysList();

        return list;
    }

    public void setList(List<holidays> list) {
        this.list = list;
    }

    public String create() {

        this.getDao().createHolidays(entity);
        this.entity = new holidays();
        return "index";
    }

    public void delete(holidays c) {
        this.getDao().delete(c);
    }

    public void update() {
        this.getDao().update(this.entity);
        this.entity = new holidays();
    }

}
