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
 * @author DELL
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
        this.list = this.getDao().getHotelsList(page, pageSize);
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

    public void clear() {
        entity = new hotels();
    }
}
