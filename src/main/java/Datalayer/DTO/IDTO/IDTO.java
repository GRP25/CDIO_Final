package Datalayer.DTO.IDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDTO {

	IDTO interpretResultSet(ResultSet resultSet) throws SQLException;

	Object[] convertToObject();

}