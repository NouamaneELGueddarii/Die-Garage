
public class Fahrzeug extends Thread{
	String nummernsChild;
	String art;
	Parkhaus parkhaus;
	int parkingTime;
	int leavingTime;
	
	
	public Fahrzeug(String nummernsChild, String art,int parkingTime ,int leavingTime,Parkhaus parkhaus) {

		this.nummernsChild = nummernsChild;
		this.art = art;
		this.parkingTime = parkingTime;
		this.leavingTime = leavingTime;
		this.parkhaus = parkhaus;
	}
	
	public String getNummernsChild() {
		return nummernsChild;
	}

	public void setNummernsChild(String nummernsChild) {
		this.nummernsChild = nummernsChild;
	}

	public int getParkenZeit() {
		return parkingTime;
	}

	public void setParkenZeit(int parkenZeit) {
		this.parkingTime = parkenZeit;
	}
	public String getArt() {
		return this.art;
	}
	
	public void setArt(String art) {
		this.art = art;
	}
	
	@Override
	public String toString() {
		return "Fahrzeug [nummernsChild=" + nummernsChild + "]";
	}
	
	
	
	public void run() {

        System.out.println("Fahrzeug losgefahren: " + this);

		this.parkhaus.Parken(this);
		
		System.out.println("Das Fahrzeug "+this+ " ist in dem "+this.parkhaus.getSpot(this).toString()+" geparkt!");
		
		try {
			sleep(parkingTime);
		}catch (Exception e) {
			
		}
		
		this.parkhaus.verlassen(this);
		
		try {
			sleep(leavingTime);
		}catch (Exception e) {
		}
	}

	
	
}
