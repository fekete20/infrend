package infrend_assignment.model;



public class Admin {
	
	
	private int id;
	

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
