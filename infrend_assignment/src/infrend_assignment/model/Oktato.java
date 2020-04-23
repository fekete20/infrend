package infrend_assignment.model;

import java.util.ArrayList;

public class Oktato {
	private int id;
	private String nev;
	private String tanszek;
	private ArrayList<String> oktatott_targyak = new ArrayList<String>();

	public Oktato(int id, String name, String tanszek, ArrayList<String> oktatott_targyak) {
		// super();
		this.id = id;
		this.nev = name;
		this.tanszek = tanszek;
		this.oktatott_targyak = oktatott_targyak;
	}
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return nev;
	}

	public void setName(String name) {
		this.nev = name;
	}

	public String getTanszek() {
		return tanszek;
	}

	public void setTanszek(String tanszek) {
		this.tanszek = tanszek;
	}

	public ArrayList<String> getOktatott_targyak() {
		return oktatott_targyak;
	}

	public void setOktatott_targyak(ArrayList<String> oktatott_targyak) {
		this.oktatott_targyak = oktatott_targyak;
	}

	@Override
	public String toString() {
		return "Oktató neve: " + nev + ", oktatott tárgyai:" + oktatott_targyak;
	}

}
