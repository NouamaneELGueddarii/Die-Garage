import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
	Scanner scanner = new Scanner (System.in);
	System.out.println("das Nummer von Etagen eingeben: ");
	int numberOfFloors = scanner.nextInt();
	System.out.println("Nummer von Plätzen in jede Etage eingeben :");
	int numberOfSpots = scanner.nextInt();
	Parkhaus parkhaus = new Parkhaus(numberOfFloors,numberOfSpots);
	
	
	
	
	// hier werden die Autos generiert
    for (int i = 100; i <= 120; i++)
    {
        new Fahrzeug("AC-EG-"+i, "auto",(int) (Math.random()*20000),(int) (Math.random()*200),parkhaus).start();
    }       
	}

}
