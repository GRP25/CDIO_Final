package Datalayer.DTO;

public class userDTO {
    private int userID;
    private String firstName;
    private String surname;
    private String cpr;
    private String initials;
    private String[] roles;

    public userDTO(int userID, String firstName, String surname, String cpr, String initials, String[] roles) {
        this.userID = userID;
        this.firstName = firstName;
        this.surname = surname;
        this.cpr = cpr;
        this.initials = initials;
        this.roles = roles;
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

    public void setRoles(String[] roles) {
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

    public String[] getRoles() {
        return roles;
    }
}