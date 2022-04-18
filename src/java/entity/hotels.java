
package entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author aysetunc
 */
public class hotels {

    private int hotels_id;
    private String hotel_date;
    private String hotel_area;
    List<consideration> cons;
    private users users;

    public hotels() {
    }

    public hotels(int hotels_id, String hotel_date, String hotel_area, List<consideration> cons) {
        this.hotels_id = hotels_id;
        this.hotel_date = hotel_date;
        this.hotel_area = hotel_area;
        this.cons = cons;
    }

    public hotels(int hotels_id, String hotel_date, String hotel_area, List<consideration> cons, users users) {
        this.hotels_id = hotels_id;
        this.hotel_date = hotel_date;
        this.hotel_area = hotel_area;
        this.cons = cons;
        this.users = users;
    }

    public hotels(int hotels_id, String hotel_date, String hotel_area) {
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

    public String getHotel_date() {
        return hotel_date;
    }

    public void setHotel_date(String hotel_date) {
        this.hotel_date = hotel_date;
    }

    public String getHotel_area() {
        return hotel_area;
    }

    public void setHotel_area(String hotel_area) {
        this.hotel_area = hotel_area;
    }

    public List<consideration> getCons() {
        return cons;
    }

    public void setCons(List<consideration> cons) {
        this.cons = cons;
    }

    public users getUsers() {
        return users;
    }

    public void setUsers(users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.hotels_id;
        hash = 97 * hash + Objects.hashCode(this.hotel_date);
        hash = 97 * hash + Objects.hashCode(this.hotel_area);
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
        final hotels other = (hotels) obj;
        if (this.hotels_id != other.hotels_id) {
            return false;
        }
        if (!Objects.equals(this.hotel_date, other.hotel_date)) {
            return false;
        }
        return Objects.equals(this.hotel_area, other.hotel_area);
    }
    

}

