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
 * @author serpl
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
        this.list = this.getDao().getHolidaysList(page, pageSize);
        return list;
    }

    public void setList(List<holidays> list) {
        this.list = list;
    }

    public void createHolidays() {

        this.getDao().createHolidays(entity);
        this.entity = new holidays();

    }

    public void delete(holidays c) {
        this.getDao().delete(c);
    }

    public void update() {
        this.getDao().update(this.entity);
        this.entity = new holidays();
    }

    public void clear() {
        entity = new holidays();
    }
}
