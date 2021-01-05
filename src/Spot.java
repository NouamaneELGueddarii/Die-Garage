
public class Spot {
	
	private int etage;
	private int platz;
	private Fahrzeug fahrzeug;

	public Spot(int i, int j ,Fahrzeug car) {
		this.etage =i;
		this.platz = j;
		this.fahrzeug = car;
	}
	
	public Fahrzeug getFahrzeug() {
		return fahrzeug;
	}

	public void setFahrzeug(Fahrzeug fahrzeug) {
		this.fahrzeug = fahrzeug;
	}
	
	public int getEtage() {
		return etage;
	}
	public void setEtage(int etage) {
		this.etage = etage;
	}
	public int getPlatz() {
		return platz;
	}
	public void setPlatz(int platz) {
		this.platz = platz;
	}
	
	@Override
	public String toString() {
		return "Spot [etage=" + etage + ", platz=" + platz + ", fahrzeug=" + fahrzeug + "]";
	}

	
	
	

}
