package infrend_assignment;

import java.util.HashMap;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class Hallgato {
		
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Id
		private int id;
		
		@NotNull(message = "A n�v nem lehet �res!")
		private String name;
		@NotNull(message = "A tank�r nem lehet �res!")
		private String tankor;
		private HashMap<String, Integer> hallgatott_targyak = new HashMap<String, Integer>();

//		private ArrayList<String> hallgatott_targyak = new ArrayList<String>();
		public Hallgato(int id, String name, String tankor, HashMap<String, Integer> hallgatott_targyak) {
			// super();
			this.id = id;
			this.name = name;
			this.tankor = tankor;
			this.hallgatott_targyak = hallgatott_targyak;
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

		public HashMap<String, Integer> getHallgatott_targyak() {
			return hallgatott_targyak;
		}

		public void setHallgatott_targyak(HashMap<String, Integer> hallgatott_targyak) {
			this.hallgatott_targyak = hallgatott_targyak;
		}

		@Override
		public String toString() {
			return "Hallgat� neve: " + name + ", tank�r: " + tankor + ", hallgatott t�rgyak �s �rdemjegy: "
					+ hallgatott_targyak;
		}

}
