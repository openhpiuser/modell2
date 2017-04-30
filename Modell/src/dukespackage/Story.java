
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
		
		//Duke versucht, die Eingangstür zu öffnen, was fehlschlägt
		System.out.println("");
		System.out.println("Duke versucht, die Eingangstür zu öffnen, was zunächst fehlschlägt");
		System.out.println("und die static-Variablen in FrontDoor auch gleich hochzählen:");
		headquarters.openFrontDoor("42");
		headquarters.openFrontDoor("Sesam öffne dich");

		//vom Roboter bekommt er das Passwort, jetzt gelingt der Zutritt
		System.out.println("Vom Roboter bekommt Duke das Passwort, jetzt gelingt der Zutritt");
		headquarters.openFrontDoor("evilEike");
		
		//Duke betritt das Hauptquartier, findet zunächst die Küche und dann das Büro
		System.out.println(lineSeparator +"Duke betritt das Hauptquartier und findet als erstes"
				+ " die Küche," + lineSeparator 
				+ "wo er erstmal ein Glas Milch trinkt." + lineSeparator
				+ "dann öffnet er eine Tür zum Büro");
		((NormalDoor)headquarters.getRooms().get("Kitchen").doors.get(0)).open();
		((NormalDoor)headquarters.getRooms().get("Office").doors.get(0)).open();
		
		//Am PC kann duke den owner neu setzen:
		System.out.println(lineSeparator + "Duke nimmt das Hauptquartier auch gleich "
				+ "in Besitz, da kennt er nix");
		headquarters.setOwner(duke);
		headquarters.printInfo();
		
		//Duke lässt sich die Rauminfo geben, um das Hauptquartier zu inspizieren:
		System.out.println(lineSeparator + "Duke lässt sich die Rauminfo geben, um das "
				+ "Hauptquartier zu inspizieren.");		
		headquarters.printRoomInfo();
		
		//DoorInfo
		System.out.println(lineSeparator + "Auch den Zustand der Türen kann sich Duke "
				+ "ausgeben lassen");
		headquarters.printDoorInfo();
	
		headquarters.printSensorInfo();
		
		System.out.println("Duke öffnet den Safe im Saferaum und findet den Papagei");
		headquarters.openSafeDoor("evilEike");
		
		System.out.println(lineSeparator + "Duke findet Paco in einem Vogelkäfig im Kerker "
				+ "und befreit ihn aus seinem Gefängnis.");
		paco.fly();
		
	}
}
