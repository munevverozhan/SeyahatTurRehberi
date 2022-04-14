/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.usersDAO;
import entity.users;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
/**
 *
 * @author serpl
 */
@Named(value = "usersBean")
@SessionScoped
public class usersBean implements Serializable {

    /**
     * Creates a new instance of usersBean
     */
    public usersBean() {
        
    }
    private users entity;
    private usersDAO dao;
    private List<users> list;
    
    public users getEntity() {
        if (this.entity == null) {
            this.entity = new users();
        }
        return entity;
    }

    public void setEntity(users entity) {
        this.entity = entity;
    }

    public usersDAO getDao() {
        if (this.dao == null) {
            this.dao = new usersDAO();
        }
        return dao;
    }

   
    public void setDao(usersDAO dao) {
        this.dao = dao;
    }

    public List<users> getList() {
        this.list = this.getDao().getUsersList();
        return list;
    }

    public void setList(List<users> list) {
        this.list = list;
    }

    public void createUsers() {

        this.getDao().createUsers(entity);
        this.entity = new users();
        
    }

    public void delete(users c) {
        this.getDao().delete(c);
    }

    public void update() {
        this.getDao().update(this.entity);
        this.entity = new users();
    }

}
