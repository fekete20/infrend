package infrend_assignment;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class Admin {
	
	@Id
	private int id;
	
	@NotNull(message="A név nem lehet üres.")
	private String name;

	public Admin(String name, int id) {
		// super();
		this.name = name;
		this.id= id;
		
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

	@Override
	public String toString() {
		return "Adminisztrátor neve: " + name;
	}
	
	public void createHallgato(String nev) {
		
	}
	
	public void createOktato(String nev) {
		
	}
	
	public void createTargy(String nev) {
		
	}
	
	public void createKurzus(String nev) {
		
	}
	
	public void deleteKurzus(String nev) {
		
	}
	
	public void osszerendelHallg(Hallgato h) {
		
	}
	
	public void osszerendelOkt(Oktato o) {
		
	}
	
	public void jegybeiras(int mark) {
		
	}

}
