package Datalayer.DTO;

import Datalayer.DTO.IDTO.IDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PrescriptionDTO implements IDTO {
    private int    prescription_id;
    private String prescription_name;

    public PrescriptionDTO() {
    }

    public PrescriptionDTO(int prescription_id, String prescription_name) {
        this.prescription_id = prescription_id;
        this.prescription_name = prescription_name;
    }

    @Override
    public Object[] convertToObject() {
        Object[] object = new Object[2];
        object[0] = this.prescription_id;
        object[1] = this.prescription_name;
        return object;
    }

    @Override
    public IDTO interpretResultSet(ResultSet resultSet) throws SQLException {
        this.setPrescription_id(resultSet.getInt(1));
        this.setPrescription_name(resultSet.getString(2));
        return this;
    }

    public int getPrescription_id() {
        return prescription_id;
    }

    public void setPrescription_id(int prescription_id) {
        this.prescription_id = prescription_id;
    }

    public String getPrescription_name() {
        return prescription_name;
    }

    public void setPrescription_name(String prescription_name) {
        this.prescription_name = prescription_name;
    }

    @Override
    public String toString() {
        return "PrescriptionDTO{" +
                "prescription_id=" + prescription_id +
                ", prescription_name='" + prescription_name + '\'' +
                '}';
    }
}
