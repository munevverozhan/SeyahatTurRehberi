/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.hotelsDAO;
import entity.hotels;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author aysetunc
 */
@FacesConverter("hotelsConverter")

public class HotelsConverter implements Converter {

    private hotelsDAO hotelsDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int hotels_id = Integer.valueOf(string);
        hotels c = this.getHotelsDao().findByID(hotels_id);
        return c;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        hotels c = (hotels) t;
        return String.valueOf(c.getHotels_id());
    }

    public hotelsDAO getHotelsDao() {
        if(hotelsDao==null){
            this.hotelsDao=new hotelsDAO();
        }  
        return hotelsDao;
    }

    public void setHotelsDao(hotelsDAO hotelsDao) {
        this.hotelsDao = hotelsDao;
    }

}

