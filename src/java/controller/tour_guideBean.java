/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.tour_guideDAO;
import entity.tour_guide;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author DELL
 */
@Named(value = "tour_guideBean")
@SessionScoped
public class tour_guideBean implements Serializable {

    public tour_guideBean() {
    }
    private tour_guide entity;
    private tour_guideDAO dao;
    private List<tour_guide> list;

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

    public tour_guide getEntity() {
        if (this.entity == null) {
            this.entity = new tour_guide();
        }
        return entity;
    }

    public void setEntity(tour_guide entity) {
        this.entity = entity;
    }

    public tour_guideDAO getDao() {
        if (this.dao == null) {
            this.dao = new tour_guideDAO();
        }
        return dao;
    }

    public void setDao(tour_guideDAO dao) {
        this.dao = dao;
    }

    public List<tour_guide> getList() {
        this.list = this.getDao().getTour_guideList(page, pageSize);
        return list;
    }

    public void setList(List<tour_guide> list) {
        this.list = list;
    }

    public void create() {

        this.getDao().create(entity);
        this.entity = new tour_guide();

    }

    public void delete(tour_guide c) {
        this.getDao().delete(c);
    }

    public void update() {
        this.getDao().update(this.entity);
        this.entity = new tour_guide();
    }

    public void clear() {
        entity = new tour_guide();
    }

}
