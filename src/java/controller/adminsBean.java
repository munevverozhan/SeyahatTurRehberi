/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.adminsDAO;
import entity.admins;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author munevver
 */
@Named(value = "adminsBean")
@SessionScoped
public class adminsBean implements Serializable {

    /**
     * Creates a new instance of adminsBean
     */
    public adminsBean() {
    }
    public boolean validatePassword(FacesContext context, UIComponent cmp, Object value) throws ValidatorException {

        String v = (String) value;
        if (v.isEmpty()) {
            throw new ValidatorException(new FacesMessage("Şifre alanı boş olamaz."));
        } else if (v.length() < 7) {
            throw new ValidatorException(new FacesMessage("Şifre alanı 8 karakterden kısa olamaz."));

        }
        return true;
    }
    private admins entity;
    private adminsDAO dao;
    private List<admins> list;

    public admins getEntity() {
        if (this.entity == null) {
            this.entity = new admins();
        }
        return entity;
    }

    public void setEntity(admins entity) {
        this.entity = entity;
    }

    public adminsDAO getDao() {
        if (this.dao == null) {
            this.dao = new adminsDAO();
        }
        return dao;
    }

    public void setDao(adminsDAO dao) {
        this.dao = dao;
    }

    public List<admins> getList() {
        this.list = this.getDao().getAdminsList();
        return list;
    }

    public void setList(List<admins> list) {
        this.list = list;
    }

    public void create() {

        this.getDao().createAdmins(entity);
        this.entity = new admins();

    }

    public void delete(admins c) {
        this.getDao().delete(c);
    }

    public void update() {
        this.getDao().update(this.entity);
        this.entity = new admins();
    }

}
