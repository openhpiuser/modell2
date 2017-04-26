
package dukespackage;
public class Story {
	final static String lineSeparator = System.getProperty("line.separator");
	public static void main(String[] args) {
		
		//Personen erstellen:
		Person eike = new Person("Eike", "Vil");
		Person duke = new Person("Duke", "der Duke");
		
		//das Hauptquartier Eikes wird gebaut:
		Headquarters headquarters = new Headquarters(eike);
		
		//Besitzer ist Eike
		headquarters.getInfo();

		
		
		//Duke versucht sich die Eingangst�r zu �ffnen, was fehlschl�gt
		System.out.println("");
		System.out.println("Duke versucht sich die Eingangst�r zu �ffnen, was fehlschl�gt:");
		headquarters.openFrontDoor("42");
		headquarters.openFrontDoor("Sesam �ffne dich");

		//vom Roboter bekommt er das Passwort, jetzt gelingt der Zutritt
		headquarters.openFrontDoor("evilEike");
		
		//nachdem die Eingangst�r offen ist, kann duke den owner neu setzen:
		headquarters.setOwner(duke);
		headquarters.getInfo();
		
		//Duke l�sst sich die Rauminfo geben, um das Hauptquartier zu inspizieren:
		headquarters.getRoomInfo();
		
	}
}
