/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entity.users;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author munevver
 */
@Named(value="lc")
@SessionScoped
public class LoginController implements Serializable {

    private users user;

    public LoginController() {
        
        
    }

    public void login(){
        if(user.getFirst_name().equals("test") && user.getPasswords().equals("123")){ // bu durumda izin verilir yani oturuma eklenir.
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("validUser", user);
        }else{ //bu durumda izin verilmez
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Username or Password is wrong!"));
        }
    }

    public users getUser() {
          if(user==null){
            this.user=new users();
        }
        return user;
    }

    public void setUser(users user) {
        this.user = user;
    }
 

    

}
