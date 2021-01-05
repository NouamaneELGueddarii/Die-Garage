import java.util.*;
public class Parkhaus {
	private int  parkEtagen;
	private int parkPlacesProEtage;
	private List<Spot>spots = Collections.synchronizedList(new ArrayList<Spot>());
	private int etage;
	private int parkplatz;
	private int freePlaces;// to not have to iterate throughout the whole grid again to get the number of  free places 

	
	
	 public Parkhaus( int numEtagen, int parkplaces) {
		super();
		this. parkEtagen = numEtagen;
		this.parkPlacesProEtage = parkplaces;
		freePlaces = numEtagen*parkplaces;
		etage = 1;
		parkplatz = 1;
	}

	
	
	// park the auto 
	synchronized public void Parken(Fahrzeug car) {		
		
		// wait till there is a free spot in the ParkingLot
		while(freePlaces <=0) {
			System.out.println("Das Auto "+car+" muss warten bis ein platz frei ist! ");
			try {
                wait();
            } catch (Exception e) {
                throw new Error(e);
            }
		}
		
        System.out.println("Einfahrt erfolgreich: " + car + " fährt in das Parkhaus.");		
        
	
		if(freePlaces > 0) {
			
			// the limit in an etage is reached  
			if(parkplatz >= parkPlacesProEtage && etage <  parkEtagen) {
				
	            parkplatz = 1;
	            etage++;
	            
	            spots.add(new Spot(etage,parkplatz,car));
	            System.out.println("Parkplatz reserviert: " + car + " bekommt einen Parkplatz in etage "+etage + " spotNumber "+ parkplatz+" zugewiesen.");
	            freePlaces --;
	            status();
	            
			}else {
				
			// 	there are still places in an etage
			spots.add(new Spot(etage,parkplatz,car));
            System.out.println("Parkplatz reserviert: " + car + " bekommt einen Parkplatz in etage "+etage + " spotNumber "+ parkplatz+" zugewiesen.");
			freePlaces --;
			parkplatz++;
            status();
			}
		}
        notifyAll();
		}
	
	
	synchronized public void exit(Fahrzeug car) {
		Spot spotToRemove = spots.stream().filter(x->car.nummernsChild.equals(x.getFahrzeug().nummernsChild)).findAny().orElse(null);
		spots.remove(spotToRemove);
		freePlaces ++;
		
		//update the etages  and the places
		etage = spotToRemove.getEtage();
		parkplatz=spotToRemove.getPlatz();
		
        System.out.println("Parkplatz verlassen: " + car + " fährt zur Ausfahrt.");
		System.out.println("Status: der Platz in der Etage "+etage+" Num "+parkplatz+" ist wieder frei");

        notifyAll();

	}	
	
	
	public Spot getSpot(Fahrzeug car) {	
		Spot spot = spots.stream().filter(x->car.nummernsChild.equals(x.getFahrzeug().nummernsChild)).findAny().orElse(null); 
		return  spot;
	}
	
	//
	private void status () {
		//System.out.println("Status: die Plätze in der Etage"+Etage+" Num "+parkplatz+"ist wider frei");
        System.out.println("Status: Es sind noch " + freePlaces + " Parkplätze frei.");
    }
}
