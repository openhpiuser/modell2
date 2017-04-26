package dukespackage;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Headquarters {
	private Person owner;
	private FrontDoor frontdoor;
	private HashMap<String,Room> rooms = new HashMap<>();
	public Person getOwner() {	return owner;	}
	public void setOwner(Person owner) { this.owner = owner; }
	
	/*Konstruktor: Die Teile des Headquarters werden hier im Konstruktor
	 * zusammengebaut. Das Headquarter: Bei einer Aggregation, wuerden alle 
	 * Werte und Objekte dem Konstruktor uebergeben werden,
	 * dann würde der Zusammenbau außerhalb z.B. in der Klasse Story erfolgen.
	 * Wegen der zahlreichen Objekte wird hier anders vorgegangen. Das Headquarter 
	 * ist also eher eine Komposition. (Komposition, wenn die Objekte im Konstruktor 
	 * selbst erstellt oder die Attribute im Konstruktor mit Werten belegt werden)
	 * 
	 */
	
	public Headquarters(Person owner) {
		//super(); wird impliziz durchgeführt
		this.owner = owner;
		
		//die Eingangstür erstellen (ist eine Sicherheitstür,
		//der ein Code als Passwort übergeben werden muss
		frontdoor = new FrontDoor("evilEike");
		
		//normale Zimmertüren aus Holz erstellen (hier im normalen Array, 
		//vielleicht besser als ArrayList)
		NormalDoor[] normalDoors = new NormalDoor[2];
		NormalDoor normalWoodDoor_01 = new NormalDoor("wood");
		NormalDoor normalWoodDoor_02 = new NormalDoor("wood");
		normalDoors[0] = normalWoodDoor_01;
		normalDoors[1] = normalWoodDoor_02;
		
		ArrayList<Door> kitchenDoors = new ArrayList<>();
		kitchenDoors.add(normalDoors[0]);
		
		ArrayList<Door> bedroomDoors = new ArrayList<>();
		bedroomDoors.add(normalDoors[1]);
		
		//eine blaue 12 qm große Küche mit..
		Room kitchen = new Kitchen(12.0, new Color(0,0,255), kitchenDoors);
		Room bedroom = new Bedroom(14.0, new Color(255, 100, 200), bedroomDoors);
		
		//die Räume der hashMap rooms hinzufügen:
		rooms.put("kitchen", kitchen);
		rooms.put("Bedroom", bedroom);
	}
	
	//das überwachte intelligente Hauptquartier kann eine Auflistung aller Räume zurückgeben
	public void printRoomList(){
		//über die Einträge im HashMap iterieren
		Room room;
		//nur eine Referenz auf einen Raum
		for (Entry<String, Room> e : rooms.entrySet()){
			room = e.getValue();
			System.out.println("Raum: " + e.getKey() + " " + room.toString());
		}
	}
	
	//das überwachte intelligente Hauptquartier kann den Zustand aller Türen zurückgeben
	//to do
	
	//das überwachte intelligente Hauptquartier kann die Daten aller Sensoren zurückgeben
	//to do 
}
