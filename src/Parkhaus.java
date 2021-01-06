import java.util.*;

public class Parkhaus {
	
	private int  numOfFloors;
	private int  freeSpotsProFloor;
	
	// list of the spots in the Parkhaus 
	private List<Spot>spots = Collections.synchronizedList(new ArrayList<Spot>());
	
	private int parkingFloor;
	private int parkPlaceInFloor;
	private int freeSpots;
	
	
	 public Parkhaus( int numOfFloors, int parkplaces) {
		super();
		
		this. numOfFloors = numOfFloors;
		this.freeSpotsProFloor = parkplaces;
		
		// Der Nummer von freie Pl�tze berechnen
		freeSpots = numOfFloors*parkplaces;
		
		// Um die parkSpot zu definieren
		parkingFloor = 1;
		parkPlaceInFloor = 1;
	}

	
	
	synchronized public void Parken(Fahrzeug vehicule) {		
		
		// warten, bis ein freier Platz auf dem ParkingLot vorhanden ist
		while(freeSpots <=0) {
			System.out.println("Das Auto "+vehicule+" muss warten bis ein platz frei ist! ");
			try {
                wait();
            } catch (Exception e) {
                throw new Error(e);
            }
		}
		
        System.out.println("Einfahrt erfolgreich: " + vehicule + " f�hrt in das Parkhaus.");		
        
		
			
			// der Grenzwert in einer Etage erreicht ist  
			if(parkPlaceInFloor >= freeSpotsProFloor && parkingFloor <  numOfFloors) {
	            parkPlaceInFloor = 1;
	            parkingFloor++;
	            spots.add(new Spot(parkingFloor,parkPlaceInFloor,vehicule));
	            System.out.println("Parkplatz reserviert: " + vehicule + " ist ein Stellplatz auf Etage "+parkingFloor + " spotNummer "+ parkPlaceInFloor+" zugewiesen.");
	            freeSpots --;
	            status();
	            
			}else {
				
			// 	noch freie Pl�tze in einer Etage vorhanden sind
			spots.add(new Spot(parkingFloor,parkPlaceInFloor,vehicule));
            System.out.println("Parkplatz reserviert: " + vehicule + " ist ein Stellplatz auf Etage "+parkingFloor + " spotNummer "+ parkPlaceInFloor+" zugewiesen.");
			freeSpots --;
			parkPlaceInFloor++;
            status();
			}
		}
		
	
	
	synchronized public void verlassen(Fahrzeug vehicule) {
		Spot spotToRemove = spots.stream().filter(x->vehicule.nummernsChild.equals(x.getFahrzeug().nummernsChild)).findAny().orElse(null);
		spots.remove(spotToRemove);
		freeSpots ++;
		
		//Aktualisierung  von den Etagen und die Orte
		parkingFloor = spotToRemove.getEtage();
		parkPlaceInFloor=spotToRemove.getPlatz();
		
        System.out.println("Parkplatz verlassen: " + vehicule + " f�hrt zur Ausfahrt.");
		System.out.println("Status: der Platz auf der Etage "+parkingFloor+" Num "+parkPlaceInFloor+" ist wieder frei");

        notifyAll();

	}	
	
	// gibt die Stelle eines Autos basierend auf dem Nummernschild zur�ck
	synchronized public Spot getSpot(Fahrzeug car) {	
		Spot spot = spots.stream().filter(x->car.nummernsChild.equals(x.getFahrzeug().nummernsChild)).findAny().orElse(null); 
		return  spot;
	}
	
	//gibt die freien Pl�tze jedes Mal an, wenn ein Auto geparkt wird oder abf�hrt
	private void status () {
        System.out.println("Status: Es sind noch " + freeSpots + " Parkpl�tze frei.");
    }
}
