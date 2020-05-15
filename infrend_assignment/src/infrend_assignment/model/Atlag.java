package infrend_assignment.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@SuppressWarnings("deprecation")
@ManagedBean
@RequestScoped
public class Atlag {
	private String tankor;
	private Double avg;

	public Atlag(String tankor, Double avg) {
		this.tankor = tankor;
		this.avg = avg;
	}

	public Atlag() {

	}

	public String getTankor() {
		return tankor;
	}

	public void setTankor(String tankor) {
		this.tankor = tankor;
	}

	public Double getAvg() {
		return avg;
	}

	public void setAvg(Double atlag) {
		this.avg = atlag;
	}

	@Override
	public String toString() {
		return "Atlag [tankor=" + tankor + ", atlag=" + avg + ", connection=" + connection + "]";
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

	ArrayList<Atlag> atlagok;

	public ArrayList<Atlag> atlagSzamitas() {
		try {
			connection = getConnection();
			Statement stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select tankor, avg(jegy) from hallgato group by tankor");
			atlagok = new ArrayList<>();
			while (rs.next()) {
				Atlag atlag = new Atlag();
				atlag.setTankor(rs.getString("tankor"));
				atlag.setAvg(rs.getDouble("avg(jegy)"));
				atlagok.add(atlag);

				atlag.toString();
			}
			connection.close();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return atlagok;
	}

}
