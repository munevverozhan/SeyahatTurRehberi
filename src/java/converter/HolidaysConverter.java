/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.holidaysDAO;
import entity.holidays;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author aysetunc
 */
@FacesConverter("holidaysConverter")

public class HolidaysConverter implements Converter {

    private holidaysDAO holidaysDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int holidays_id = Integer.valueOf(string);
        holidays c = this.getHolidaysDao().findByID(holidays_id);
        return c;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        holidays c = (holidays) t;
        return String.valueOf(c.getHolidays_id());
    }

    public holidaysDAO getHolidaysDao() {
        if (holidaysDao == null) {
            this.holidaysDao = new holidaysDAO();
        }
        return holidaysDao;
    }

    public void setHolidaysDao(holidaysDAO holidaysDao) {
        this.holidaysDao = holidaysDao;
    }

}

