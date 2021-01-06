import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
	Scanner scanner = new Scanner (System.in);
	System.out.println("Geben Sie die Anzahl der Etagen ein: ");
	int numberOfFloors = scanner.nextInt();
	System.out.println("Geben Sie die Anzahl der Spots auf jeder Etage ein: ");
	int numberOfSpots = scanner.nextInt();
	Parkhaus parkhaus = new Parkhaus(numberOfFloors,numberOfSpots);
	
	
	
	
	// hier werden die Autos generiert
    for (int i = 100; i <= 310; i++)
    {
        new Fahrzeug("AC-EG-"+i, "Auto",(int) (Math.random()*30000),(int) (Math.random()*3000),parkhaus).start();
    }       
	}

}
