
public class Spot {
	
	private int etage;
	private int spot;
	private Fahrzeug fahrzeug;

	public Spot(int i, int j ,Fahrzeug car) {
		this.etage =i;
		this.spot = j;
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
		return spot;
	}
	public void setPlatz(int platz) {
		this.spot = platz;
	}
	
	@Override
	public String toString() {
		return "Spot [etage=" + etage + ", platz=" + spot + "]";
	}

	
	
	

}
