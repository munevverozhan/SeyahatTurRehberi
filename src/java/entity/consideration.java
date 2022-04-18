/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author aysetunc
 */
public class consideration {

    private int consideration_id;
    private String context;
    List<users> useries;

    public consideration() {
    }

    public consideration(int consideration_id, String context, List<users> useries) {
        this.consideration_id = consideration_id;
        this.context = context;
        this.useries = useries;
    }

    public consideration(int consideration_id, String context) {
        this.consideration_id = consideration_id;
        this.context = context;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getConsideration_id() {
        return consideration_id;
    }

    public void setConsideration_id(int consideration_id) {
        this.consideration_id = consideration_id;
    }

    public List<users> getUseries() {
        return useries;
    }

    public void setUseries(List<users> useries) {
        this.useries = useries;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.consideration_id;
        hash = 17 * hash + Objects.hashCode(this.context);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final consideration other = (consideration) obj;
        if (this.consideration_id != other.consideration_id) {
            return false;
        }
        return Objects.equals(this.context, other.context);
    }




}

