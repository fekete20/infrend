package assignment.model;

import java.util.ArrayList;
//import java.util.List;

public class Oktato {
	private String name;
	private String tanszek;
	private ArrayList<String> oktatott_targyak = new ArrayList<String>();
	
	
	public Oktato(String name, String tanszek, ArrayList<String> oktatott_targyak) {
		//super();
		this.name = name;
		this.tanszek = tanszek;
		this.oktatott_targyak = oktatott_targyak;
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


	public ArrayList<String> getOktatott_targyak() {
		return oktatott_targyak;
	}


	public void setOktatott_targyak(ArrayList<String> oktatott_targyak) {
		this.oktatott_targyak = oktatott_targyak;
	}


	@Override
	public String toString() {
		return "Oktato [name=" + name + ", tanszek=" + tanszek + ", oktatott_targyak=" + oktatott_targyak + "]";
	}
	
	
	
	
	
	
	

}
