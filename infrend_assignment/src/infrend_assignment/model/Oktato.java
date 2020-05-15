package infrend_assignment.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@SuppressWarnings("deprecation")
@ManagedBean
@RequestScoped
public class Oktato {
	private int id;
	private String name;
	private String tanszek;
	private String oktatottTargyak;

	public Oktato(int id, String name, String tanszek, String oktatottTargyak) {
		this.id = id;
		this.name = name;
		this.tanszek = tanszek;
		this.oktatottTargyak = oktatottTargyak;
	}

	public Oktato() {

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

	public String getTanszek() {
		return tanszek;
	}

	public void setTanszek(String tanszek) {
		this.tanszek = tanszek;
	}

	public String getOktatottTargyak() {
		return oktatottTargyak;
	}

	public void setOktatottTargyak(String oktatottTargyak) {
		this.oktatottTargyak = oktatottTargyak;
	}

	@Override
	public String toString() {
		return "Oktató neve: " + name + ", oktatott tárgyai:" + oktatottTargyak;
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

	private ArrayList<Oktato> oktatoLista;

	public ArrayList<Oktato> oktatoListazas() {
		try {
			oktatoLista = new ArrayList<Oktato>();
			connection = getConnection();
			Statement stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select name, oktatottTargyak from oktato");
			while (rs.next()) {
				Oktato oktato = new Oktato();
				oktato.setName(rs.getString("name"));
				oktato.setOktatottTargyak(rs.getString("oktatottTargyak"));
				oktatoLista.add(oktato);
				System.out.println(oktato.toString());
			}

			connection.close();

		} catch (Exception e) {
			System.err.println(e);
		}
		return oktatoLista;
	}

	public void addOktato() {
		try {
			connection = getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("insert into oktato(id, name, tanszek, oktatottTargyak) values(?, ?, ?, ?)");
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setString(3, tanszek);
			stmt.setString(4, oktatottTargyak);
			stmt.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
