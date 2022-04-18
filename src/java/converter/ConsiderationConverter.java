/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.considerationDAO;
import entity.consideration;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author DELL
 */
@FacesConverter("considerationConverter")
public class ConsiderationConverter implements Converter{
   
    private considerationDAO considerationDao;

@Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int consideration_id = Integer.valueOf(string);
        consideration c = this.getConsiderationDao().findByID(consideration_id);
        return c;
    }

@Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        consideration c = (consideration) t;
        return String.valueOf(c.getConsideration_id());
    }

    public considerationDAO getConsiderationDao() {
         if(considerationDao==null){
            this.considerationDao=new considerationDAO();
        }  
        return considerationDao;
    }

    public void setConsiderationDao(considerationDAO considerationDao) {
        this.considerationDao = considerationDao;
    }

  


}
