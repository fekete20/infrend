package infrend_assignment.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DAO {
	 private Connection connection;
	    private PreparedStatement preparedStatement;
	    private ResultSet resultSet;

	    public Connection connect() {
	        Properties properties = new Properties();
	        properties.put("user", "root");
	        properties.put("password", "root");
	        Connection connectionToDB;
	        try {
	            connectionToDB = DriverManager.getConnection("jdbc:mysql://localhost:3306/neptun?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", properties);
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	            return null;
	        }
	        return connectionToDB;
	    }

}
