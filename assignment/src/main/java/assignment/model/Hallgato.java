package assignment.model;

//import java.awt.List;
//import java.util.ArrayList;
//import java.util.Dictionary;
import java.util.HashMap;

public class Hallgato {
	private String name;
	private String tankor;
	private HashMap<String, Integer> hallgatott_targyak = new HashMap<String, Integer>();
//	private ArrayList<String> hallgatott_targyak = new ArrayList<String>();
	public Hallgato(String name, String tankor, HashMap<String, Integer> hallgatott_targyak) {
		//super();
		this.name = name;
		this.tankor = tankor;
		this.hallgatott_targyak = hallgatott_targyak;
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
	public HashMap<String, Integer> getHallgatott_targyak() {
		return hallgatott_targyak;
	}
	public void setHallgatott_targyak(HashMap<String, Integer> hallgatott_targyak) {
		this.hallgatott_targyak = hallgatott_targyak;
	}


	@Override
	public String toString() {
		return "Hallgato [name=" + name + ", tankor=" + tankor + ", hallgatott_targyak=" + hallgatott_targyak + "]";
	}
	
	
	
	

}
