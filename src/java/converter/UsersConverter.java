/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.usersDAO;
import entity.users;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author munevver
 */
@FacesConverter("usersConverter")
public class UsersConverter implements Converter{
    private usersDAO usersDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) { // String nesneye dönüştürülür.
        int users_id= Integer.valueOf(string);
        users c=this.getUsersDao().findByID(users_id);
        return c;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) { // nesne Stringe dönüştürülür.
        users c=(users)t;
        return String.valueOf(c.getUsers_id());
        
    }

    public usersDAO getUsersDao() {
         if(usersDao==null){
            this.usersDao=new usersDAO();
        }   
        return usersDao;
    }

    public void setUsersDao(usersDAO usersDao) {
        this.usersDao = usersDao;
    }
    
    
    
}
