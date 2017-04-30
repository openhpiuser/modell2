
package dukespackage;
public class Story {
	final static String lineSeparator = System.getProperty("line.separator");
	public static void main(String[] args) {
		
		//Akteure erstellen:
		Person eike = new Person("Eike", "Vil");
		Person duke = new Person("Duke", "der Duke");
		Parrot paco = new Parrot("Paco", "");
		
		//das Hauptquartier Eikes wird gebaut:
		Headquarters headquarters = new Headquarters(eike);
		
		//Besitzer ist Eike
		headquarters.printInfo();
		
		//Duke versucht, die Eingangst�r zu �ffnen, was fehlschl�gt
		System.out.println("");
		System.out.println("Duke versucht, die Eingangst�r zu �ffnen, was zun�chst fehlschl�gt");
		System.out.println("und die static-Variablen in FrontDoor auch gleich hochz�hlen:");
		headquarters.openFrontDoor("42");
		headquarters.openFrontDoor("Sesam �ffne dich");

		//vom Roboter bekommt er das Passwort, jetzt gelingt der Zutritt
		System.out.println("Vom Roboter bekommt Duke das Passwort, jetzt gelingt der Zutritt");
		headquarters.openFrontDoor("evilEike");
		
		//Duke betritt das Hauptquartier, findet zun�chst die K�che und dann das B�ro
		System.out.println(lineSeparator +"Duke betritt das Hauptquartier und findet als erstes"
				+ " die K�che," + lineSeparator 
				+ "wo er erstmal ein Glas Milch trinkt." + lineSeparator
				+ "dann �ffnet er eine T�r zum B�ro");
		((NormalDoor)headquarters.getRooms().get("Kitchen").doors.get(0)).open();
		((NormalDoor)headquarters.getRooms().get("Office").doors.get(0)).open();
		
		//Am PC kann duke den owner neu setzen:
		System.out.println(lineSeparator + "Duke nimmt das Hauptquartier auch gleich "
				+ "in Besitz, da kennt er nix");
		headquarters.setOwner(duke);
		headquarters.printInfo();
		
		//Duke l�sst sich die Rauminfo geben, um das Hauptquartier zu inspizieren:
		System.out.println(lineSeparator + "Duke l�sst sich die Rauminfo geben, um das "
				+ "Hauptquartier zu inspizieren.");		
		headquarters.printRoomInfo();
		
		//DoorInfo
		System.out.println(lineSeparator + "Auch den Zustand der T�ren kann sich Duke "
				+ "ausgeben lassen");
		headquarters.printDoorInfo();
	
		headquarters.printSensorInfo();
		
		System.out.println("Duke �ffnet den Safe im Saferaum und findet den Papagei");
		headquarters.openSafeDoor("evilEike");
		
		System.out.println(lineSeparator + "Duke findet Paco in einem Vogelk�fig im Kerker "
				+ "und befreit ihn aus seinem Gef�ngnis.");
		paco.fly();
		
	}
}
