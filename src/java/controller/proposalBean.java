/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.proposalDAO;
import entity.proposal;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author DELL
 */
@Named(value = "proposalBean")
@SessionScoped

/**
 * Creates a new instance of proposalBean
 */
public class proposalBean implements Serializable {

    /**
     * Creates a new instance of proposalBean
     */
    public proposalBean() {
    }
    private proposal entity;
    private proposalDAO dao;
    private List<proposal> list;

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

    public proposal getEntity() {
        if (this.entity == null) {
            this.entity = new proposal();
        }
        return entity;
    }

    public void setEntity(proposal entity) {
        this.entity = entity;
    }

    public proposalDAO getDao() {
        if (this.dao == null) {
            this.dao = new proposalDAO();
        }
        return dao;
    }

    public void setDao(proposalDAO dao) {
        this.dao = dao;
    }

    public List<proposal> getList() {
        this.list = this.getDao().getProposalList(page, pageSize);
        return list;
    }

    public void setList(List<proposal> list) {
        this.list = list;
    }

    public void create() {

        this.getDao().create(entity);
        this.entity = new proposal();

    }

    public void delete(proposal c) {
        this.getDao().delete(c);
    }

    public void update() {
        this.getDao().update(this.entity);
        this.entity = new proposal();
    }

    public void clear() {
        entity = new proposal();
    }

}
