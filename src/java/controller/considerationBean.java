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
 * @author serpl
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

    private int page = 1;
    private int pageSize = 10;
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
        this.list = this.getDao().getConsiderationList(page, pageSize);
        return list;
    }

    public void setList(List<consideration> list) {
        this.list = list;
    }

    public void delete(consideration c) {
        this.getDao().delete(c);
    }

    public void create() {

        this.getDao().create(entity);
        this.entity = new consideration();

    }

    public void update() {
        this.getDao().update(this.entity);
        this.entity = new consideration();
    }

    public void clear() {
        entity = new consideration();
    }
}
