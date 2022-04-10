/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author munevver
 */
public class admins {

    private int admins_id;
    private String mail;
    private String passwords;

    public admins() {
    }

    public admins(int admins_id, String mail, String passwords) {
        this.admins_id = admins_id;
        this.mail = mail;
        this.passwords = passwords;
    }

    public int getAdmins_id() {
        return admins_id;
    }

    public void setAdmins_id(int admins_id) {
        this.admins_id = admins_id;
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
}
