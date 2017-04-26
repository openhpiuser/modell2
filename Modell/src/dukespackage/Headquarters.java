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
	protected void setOwner(Person owner) { this.owner = owner; } //Zugriff geht trotzdem aus Story, da selbes package
	
	
	/*Konstruktor: Die Teile des Headquarters werden hier im Konstruktor
	 * zusammengebaut. Das Headquarter: Bei einer Aggregation, wuerden alle 
	 * Werte und Objekte dem Konstruktor uebergeben werden,
	 * dann w�rde der Zusammenbau au�erhalb z.B. in der Klasse Story erfolgen.
	 * Wegen der zahlreichen Objekte wird hier anders vorgegangen. Das Headquarter 
	 * ist also eher eine Komposition. (Komposition, wenn die Objekte im Konstruktor 
	 * selbst erstellt oder die Attribute im Konstruktor mit Werten belegt werden)
	 * 
	 */
	
	public Headquarters(Person owner) {
		//super(); wird impliziz durchgef�hrt
		System.out.println("Im Konstruktor von Headquarters: Das Hauptquartier wurde gebaut");
		this.owner = owner;
		
		//die Eingangst�r erstellen (ist eine Sicherheitst�r,
		//der ein Code als Passwort �bergeben werden muss
		frontdoor = new FrontDoor("evilEike");
		
		//normale Zimmert�ren aus Holz erstellen (hier im normalen Array, 
		//vielleicht besser als ArrayList)
		NormalDoor[] normalDoors = new NormalDoor[4];
		NormalDoor normalWoodDoor_01 = new NormalDoor("wood");
		NormalDoor normalWoodDoor_02 = new NormalDoor("wood");
		NormalDoor normalWoodDoor_03 = new NormalDoor("wood");
		NormalDoor normalWoodDoor_04 = new NormalDoor("wood");
		
		normalDoors[0] = normalWoodDoor_01;
		normalDoors[1] = normalWoodDoor_02;
		normalDoors[2] = normalWoodDoor_03;
		normalDoors[3] = normalWoodDoor_04;
		
		ArrayList<Door> kitchenDoors = new ArrayList<>();
		kitchenDoors.add(normalDoors[0]);
		
		ArrayList<Door> bedroomDoors = new ArrayList<>();
		bedroomDoors.add(normalDoors[1]);
		
		ArrayList<Door> officeDoors = new ArrayList<>();
		officeDoors.add(normalDoors[2]);
		officeDoors.add(normalDoors[3]);		
		
		
		//eine blaue 12 qm gro�e K�che
		Room kitchen = new Kitchen(12.0, new Color(0,0,255), kitchenDoors);
		//ein Schlafzimmer
		Room bedroom = new Bedroom(14.0, new Color(255, 100, 200), bedroomDoors);
		//ein wei�es B�ro
		Room office = new Office(18.0, new Color(255, 255, 255), officeDoors);
		
		//die R�ume der hashMap rooms hinzuf�gen:
		rooms.put("Kitchen", kitchen);
		rooms.put("Bedroom", bedroom);
		rooms.put("Office", office);
	}
	
	public void openFrontDoor(String code){
		frontdoor.open(code);
	}
	
	
	
	//das �berwachte intelligente Hauptquartier kann eine Auflistung aller R�ume zur�ckgeben
	public void getInfo(){
		System.out.println("Das Hauptquartier meldet sich:");
		System.out.println("Besitzer ist: " + this.getOwner().getFirstName() + " " + this.getOwner().getLastName()) ;
	}
	
	public void getRoomInfo(){
		Room room;	//nur eine Referenz auf einen Raum
		//�ber die Eintr�ge im HashMap iterieren
		for (Entry<String, Room> e : rooms.entrySet()){
			room = e.getValue();
			System.out.println("Raum: " + e.getKey() + " " + room.toString());
		}		
	}
	
	//das �berwachte intelligente Hauptquartier kann den Zustand aller T�ren zur�ckgeben
	//to do
	
	//das �berwachte intelligente Hauptquartier kann die Daten aller Sensoren zur�ckgeben
	//to do 
}
