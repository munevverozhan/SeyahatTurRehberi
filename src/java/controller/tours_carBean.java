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
 * @author munevver
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

    private int page = 1;
    private int pageSize = 4;
    private int pageCount;

    public void next() {
        if (this.page == pageCount)// sonraki sayfaya geçecek metod.
        {
            this.page = 1;
        } else {
            this.page++;
        }

    }

    public void previous() {// önceki sayfaya geçecek metod.
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() { // kaç tane sayfamız olduğunu bulacak olan metod.
        this.pageCount = (int) Math.ceil(this.getDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

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
        this.list = this.getDao().getTours_carList(page, pageSize);
        return list;
    }

    public void setList(List<tours_car> list) {
        this.list = list;
    }

    public void create() {

        this.getDao().create(entity);
        this.entity = new tours_car();

    }

    public void delete(tours_car c) {
        this.getDao().delete(c);
    }

    public void update() {
        this.getDao().update(this.entity);
        this.entity = new tours_car();
    }

    public void clear() {
        entity = new tours_car();
    }

}
