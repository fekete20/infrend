package infrend_assignment.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@SuppressWarnings("deprecation")
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

	public Hallgato(int id, String name, String tankor, String hallgatottTargyak, int jegy) {
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

	public String getHallgatottTargyak() {
		return hallgatottTargyak;
	}

	public void setHallgatottTargyak(String hallgatottTargyak) {
		this.hallgatottTargyak = hallgatottTargyak;
	}

	@Override
	public String toString() {
		return "Hallgató neve: " + name + ", hallgatott tárgyak: " + hallgatottTargyak + ", érdemjegy: " + jegy;
	}

	private Connection connection;

	public Connection getConnection() {
		String username = "root";
		String password = "root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/neptun?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					username, password);
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
			Statement stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select name, hallgatottTargyak, jegy from hallgato");
			while (rs.next()) {
				Hallgato hallgato = new Hallgato();
				hallgato.setName(rs.getString("name"));
				hallgato.setHallgatottTargyak(rs.getString("hallgatottTargyak"));
				hallgato.setJegy(rs.getInt("jegy"));

				hallgatoLista.add(hallgato);
				System.out.println(hallgato.toString());
			}

			connection.close();

		} catch (Exception e) {
			System.err.println(e);
		}
		return hallgatoLista;
	}

	public void addHallgato() {
		try {
			connection = getConnection();
			PreparedStatement stmt = connection.prepareStatement(
					"insert into hallgato(id, name, tankor, hallgatottTargyak, jegy) values(?, ?, ?, ?, ?)");
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setString(3, tankor);
			stmt.setString(4, hallgatottTargyak);
			stmt.setInt(5, jegy);
			stmt.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	private ArrayList<String> nevLista;

	public ArrayList<String> nevLista() {

		try {
			nevLista = new ArrayList<String>();
			connection = getConnection();
			Statement stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select name from hallgato");
			while (rs.next()) {
				String name = rs.getString("name");
				System.out.println(nevLista);
				nevLista.add(name);
				
			}
			
			connection.close();
			
		} catch (Exception e) {
			System.err.println(e);
		}

		return nevLista;
	}

	public void jegybeiras() {
		try {
			connection = getConnection();
			PreparedStatement stmt = connection.prepareStatement("update hallgato set jegy = ? where name = ?");
			stmt.setInt(1, jegy);
			stmt.setString(2, name);
			stmt.executeUpdate();
			connection.close();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void targyFelvesz() {
		try {
			connection = getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("update hallgato set hallgatottTargyak = ? where name = ?");
			stmt.setString(1, hallgatottTargyak);
			stmt.setString(2, name);
			stmt.executeUpdate();
			connection.close();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
