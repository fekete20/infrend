package infrend_assignment.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@ManagedBean  
@RequestScoped 
public class Hallgato {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;

	@NotNull(message = "A név nem lehet üres!")
	private String name;
	@NotNull(message = "A tankör nem lehet üres!")
	private String tankor;
	
	private String hallgatottTargyak;
	
	private int jegy;
//	private HashMap<String, Integer> hallgatott_targyak = new HashMap<String, Integer>();

//		private ArrayList<String> hallgatott_targyak = new ArrayList<String>();
	public Hallgato(int id, String name, String tankor, String hallgatottTargyak, int jegy) {
		// super();
		this.id = id;
		this.name = name;
		this.tankor = tankor;
		this.hallgatottTargyak = hallgatottTargyak;
		this.jegy = jegy;
	}
	
	public Hallgato() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTankor() {
		return tankor;
	}

	public void setTankor(String tankor) {
		this.tankor = tankor;
	}
	
	

public int getJegy() {
		return jegy;
	}

	public void setJegy(int jegy) {
		this.jegy = jegy;
	}

	/*	public HashMap<String, Integer> getHallgatott_targyak() {
		return hallgatott_targyak;
	}

	public void setHallgatott_targyak(HashMap<String, Integer> hallgatott_targyak) {
		this.hallgatott_targyak = hallgatott_targyak;
	}
*/
	public String getHallgatottTargyak() {
		return hallgatottTargyak;
	}

	public void setHallgatottTargyak(String hallgatottTargyak) {
		this.hallgatottTargyak = hallgatottTargyak;
	}
	
	@Override
	public String toString() {
		return "Hallgató neve: " + name + ", tankör: " + tankor + ", hallgatott tárgyak és érdemjegy: "
				+ hallgatottTargyak;
	}

	//DB-s része 
		 private Connection connection;
		    private PreparedStatement preparedStatement;
		    private ResultSet resultSet;

		    public Connection getConnection() {
		     /*   Properties properties = new Properties();
		        properties.put("user", "root");
		        properties.put("password", "root");
		        Connection connectionToDB;*/
		        try {
		        	Class.forName("com.mysql.cj.jdbc.Driver");
		            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/neptun?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
		        } catch (Exception e) {
		            System.err.println(e.getMessage());
		            return null;
		        }
		        return connection;
		    }
		    
		    private ArrayList<Hallgato> hallgatoLista;
		    
		    public ArrayList<Hallgato> hallgatoListazas() {
		    	try {
		    		hallgatoLista = new ArrayList<Hallgato>();
		    		connection = getConnection();  
		    	    Statement stmt=getConnection().createStatement();    
		    	    ResultSet rs=stmt.executeQuery("select name, hallgatottTargyak, jegy from hallgato");    
		    	    while(rs.next()){  
		    	   Hallgato hallgato = new Hallgato();
//		    	   hallgato.setId(rs.getInt("id"));
		    	   hallgato.setName(rs.getString("name"));  
//		    	   hallgato.setTankor(rs.getString("tankor"));
		    	   hallgato.setHallgatottTargyak(rs.getString("hallgatottTargyak"));  
		    	   hallgato.setJegy(rs.getInt("jegy"));
		    	   
		    	    hallgatoLista.add(hallgato);
		    	    System.out.println(hallgato.toString());
		    	    }  
		    	    
		    	    connection.close();          
		    	   
		    		
		    	}
		    	catch(Exception e){  
		    	    System.err.println(e);  
		    	    }  
		    	return hallgatoLista;
		    }
		    
		    public void addHallgato() {
		    	int result = 0;  
		        try{  
		        connection = getConnection();  
		        PreparedStatement stmt = connection.prepareStatement("insert into hallgato(id, name, tankor, hallgatottTargyak, jegy) values(?, ?, ?, ?, ?)");  
		        stmt.setInt(1, id);  
		        stmt.setString(2, name);  
		        stmt.setString(3, tankor);  
		        stmt.setString(4, hallgatottTargyak);  
		        stmt.setInt(5, jegy);  
		        result = stmt.executeUpdate();  
		        connection.close();  
		        }catch(Exception e){  
		        System.err.println(e);  
		        }  
		    }
		    
		    public void jegybeiras() {
		    	try {
		    		connection = getConnection();
		    		PreparedStatement stmt = connection.prepareStatement("update hallgato set jegy = ? where id = ?");
		    		stmt.setInt(1, jegy);
		    		stmt.setInt(2, id);
		    		stmt.executeUpdate();
		    		connection.close();
		    		
		    	}
		    	catch (Exception e) {
		    		System.err.println(e.getMessage());
		    	}
		    }

}
