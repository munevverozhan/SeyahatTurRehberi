
package entity;

import java.util.Date;

/**
 *
 * @author serpl
 */
public class hotels {

    private int hotels_id;
    private Date hotel_date;
    private String hotel_area;

    public hotels() {
    }

    public hotels(int hotels_id, Date hotel_date, String hotel_area) {
        this.hotels_id = hotels_id;
        this.hotel_date = hotel_date;
        this.hotel_area = hotel_area;
    }

    public int getHotels_id() {
        return hotels_id;
    }

    public void setHotels_id(int hotels_id) {
        this.hotels_id = hotels_id;
    }

    public Date getHotel_date() {
        return hotel_date;
    }

    public void setHotel_date(Date hotel_date) {
        this.hotel_date = hotel_date;
    }

    public String getHotel_area() {
        return hotel_area;
    }

    public void setHotel_area(String hotel_area) {
        this.hotel_area = hotel_area;
    }

    public String getDate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
