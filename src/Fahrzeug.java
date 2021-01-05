
public class Fahrzeug extends Thread{
	String nummernsChild;
	String art;
	Parkhaus parkhaus;
	int parkenZeit;
	int leavingTime;
	
	
	public Fahrzeug(String nummernsChild, String art,int parkenZeit ,int leavingTime,Parkhaus parkhaus) {

		this.nummernsChild = nummernsChild;
		this.art = art;
		this.parkenZeit = parkenZeit;
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
		return parkenZeit;
	}

	public void setParkenZeit(int parkenZeit) {
		this.parkenZeit = parkenZeit;
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

        System.out.println("Auto losgefahren: " + this);

		this.parkhaus.Parken(this);
		System.out.println("auto "+this+ " geparkt!");
		try {
			sleep(parkenZeit);
		}catch (Exception e) {
		}
		this.parkhaus.exit(this);
		
		try {
			sleep(leavingTime);
		}catch (Exception e) {
		}
		System.out.println("-------------------------------");
	}

	
	
}
