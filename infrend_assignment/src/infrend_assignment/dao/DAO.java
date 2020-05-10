package infrend_assignment.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import infrend_assignment.model.Oktato;

public class DAO {
	 private Connection connection;
	    private PreparedStatement preparedStatement;
	    private ResultSet resultSet;

	    public Connection getConnection() {
	     /*   Properties properties = new Properties();
	        properties.put("user", "root");
	        properties.put("password", "root");
	        Connection connectionToDB;*/
	        try {
	        	Class.forName("com.mysql.jdbc.Driver");
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/neptun?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
	        } catch (Exception e) {
	            System.err.println(e.getMessage());
	            return null;
	        }
	        return connection;
	    }
	    
	    private ArrayList<Oktato> oktatoLista;
	    
	    public ArrayList oktatoLista() {
	    	try {
	    		oktatoLista = new ArrayList();
	    		connection = getConnection();  
	    	    Statement stmt=getConnection().createStatement();    
	    	    ResultSet rs=stmt.executeQuery("select * from oktato");    
	    	    while(rs.next()){  
	    	  Oktato oktato = null;
	    	    oktato.setId(rs.getInt("id"));
	    	    oktato.setName(rs.getString("nev"));  
	    	    oktato.setTanszek(rs.getString("tanszek"));
	    	    oktato.setOktatottTargyak(rs.getString("oktatottTargyak"));  
	    	    oktatoLista.add(oktato);
	    	    System.out.println(oktato.toString());
	    	    }  
	    	    
	    	    connection.close();          
	    	   
	    		
	    	}
	    	catch(Exception e){  
	    	    System.out.println(e);  
	    	    }  
	    	return oktatoLista;
	    }

}
