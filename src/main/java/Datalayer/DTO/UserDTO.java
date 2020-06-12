package Datalayer.DTO;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Datalayer.DTO.IDTO.IDTO;

public class UserDTO implements IDTO {
    private int userID;
    private String firstName;
    private String surname;
    private String cpr;
    private String initials;
    private List<String> roles;
    private int status;

    public UserDTO(int userID, String firstName, String surname, String cpr, String initials, List<String> roles,
            int status) {
        this.userID = userID;
        this.firstName = firstName;
        this.surname = surname;
        this.cpr = cpr;
        this.initials = initials;
        this.roles = roles;
        this.status = status;
    }

    public UserDTO() {

    }

    @Override
    public Object[] convertToObject() {
        Object[] object = new Object[5];
        object[0] = this.firstName;
        object[1] = this.surname;
        object[2] = this.cpr;
        object[3] = this.initials;
        object[4] = this.status;
        return object;
    }

    @Override
    public UserDTO interpretResultSet(ResultSet resultSet) throws SQLException {
        this.setUserID(resultSet.getInt(1));
        this.setFirstName(resultSet.getString(2));
        this.setSurname(resultSet.getString(3));
        this.setCpr(resultSet.getString(4));
        this.setStatus(resultSet.getInt(5));
        return this;

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

    // This might be a special case
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

    public List<String> getRoles() {
        return roles;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userID=" + userID +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", cpr='" + cpr + '\'' +
                ", initials='" + initials + '\'' +
                ", roles=" + roles +
                ", status=" + status +
                '}';
    }
}