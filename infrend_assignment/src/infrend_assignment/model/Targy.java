package infrend_assignment.model;

import java.util.List;

public class Targy {
	private String name;
	private List<String> kurzusok;

	public Targy(String name, List<String> kurzusok) {
		// super();
		this.name = name;
		this.kurzusok = kurzusok;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getKurzusok() {
		return kurzusok;
	}

	public void setKurzusok(List<String> kurzusok) {
		this.kurzusok = kurzusok;
	}

	@Override
	public String toString() {
		return "Tárgy neve: " + name + ", kurzusai: " + kurzusok;
	}

}
