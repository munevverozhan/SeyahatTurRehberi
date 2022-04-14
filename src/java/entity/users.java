/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author serpl
 */
public class users {

    private int users_id;
    private String mail;
    private String passwords;
    private String first_name;
    private String last_name;

    public users() {
    }

    public users(int users_id, String mail, String passwords, String first_name, String last_name) {
        this.users_id = users_id;
        this.mail = mail;
        this.passwords = passwords;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

   

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.users_id;
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
        final users other = (users) obj;
        return this.users_id == other.users_id;
    }
    

}
