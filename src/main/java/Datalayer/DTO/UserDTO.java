package Datalayer.DTO;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UserDTO {
    private int userID;
    private String firstName;
    private String surname;
    private String cpr;
    private String initials;
    private ArrayList<String> roles;
    private int status;

    public UserDTO(int userID, String firstName, String surname, String cpr, String initials, ArrayList<String> roles, int status) {
        this.userID = userID;
        this.firstName = firstName;
        this.surname = surname;
        this.cpr = cpr;
        this.initials = initials;
        this.roles = roles;
        this.status = status;
    }

    public UserDTO(){

    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public void setRoles(ArrayList<String> roles) {
        this.roles = roles;
    }

    public int getUserID() {
        return userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getCpr() {
        return cpr;
    }

    public String getInitials() {
        return initials;
    }

    public ArrayList<String> getRoles() {
        return roles;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}