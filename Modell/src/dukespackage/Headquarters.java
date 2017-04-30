package dukespackage;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Headquarters {
	private Person owner;
	private FrontDoor frontdoor;
	private SafeDoor safedoor;
	private HashMap<String,Room> rooms = new HashMap<>();
	public Person getOwner() {	return owner;	}
	protected void setOwner(Person owner) { this.owner = owner; } //Zugriff geht trotzdem aus Story, da selbes package
	ArrayList<Sensorable> listOfSensors = new ArrayList<>();
	
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
		//super(); wird implizit durchgeführt
		System.out.println("Im Konstruktor von Headquarters: Das Hauptquartier wurde gebaut");
		this.owner = owner;
		
		//die Eingangstür erstellen (ist eine Sicherheitstür,
		//der ein Code als Passwort übergeben werden muss
		frontdoor = new FrontDoor("evilEike");
		
		//SafeTür
		safedoor = new SafeDoor("evilEike");
		
		//normale Zimmertüren aus Holz erstellen (hier im normalen Array, 
		//vielleicht besser als ArrayList)
		NormalDoor[] normalDoors = new NormalDoor[5];
		NormalDoor normalWoodDoor_01 = new NormalDoor("wood");
		NormalDoor normalWoodDoor_02 = new NormalDoor("wood");
		NormalDoor normalWoodDoor_03 = new NormalDoor("wood");
		NormalDoor normalWoodDoor_04 = new NormalDoor("wood");
		NormalDoor normalWoodDoor_05 = new NormalDoor("wood");
		
		normalDoors[0] = normalWoodDoor_01;
		normalDoors[1] = normalWoodDoor_02;
		normalDoors[2] = normalWoodDoor_03;
		normalDoors[3] = normalWoodDoor_04;
		normalDoors[4] = normalWoodDoor_05;
		
		
		ArrayList<Door> kitchenDoors = new ArrayList<>();
		kitchenDoors.add(normalDoors[0]);
		
		ArrayList<Door> bedroomDoors = new ArrayList<>();
		bedroomDoors.add(normalDoors[1]);
		ArrayList<Interior> bedroomInterior = new ArrayList<>();
		
		Teddybear observingTeddy = new Teddybear(owner);
		SeatTrap seatTrap = new SeatTrap();
		listOfSensors.add(observingTeddy);
		listOfSensors.add(seatTrap);
		bedroomInterior.add(observingTeddy);
		
		ArrayList<Door> officeDoors = new ArrayList<>();
		officeDoors.add(normalDoors[2]);
		officeDoors.add(normalDoors[3]);
		
		ArrayList<Door> safeRoomDoors = new ArrayList<>();
		safeRoomDoors.add(normalDoors[4]);
		safeRoomDoors.add(safedoor);
		
		
		//eine blaue 12 qm große Küche
		Room kitchen = new Kitchen(12.0, new Color(0,0,255), kitchenDoors);
		//ein Schlafzimmer mit Einrichtungsgegenständen
		Room bedroom = new Bedroom(14.0, new Color(255, 100, 200), bedroomDoors, bedroomInterior);
		//ein weißes Büro
		Room office = new Office(18.0, new Color(255, 255, 255), officeDoors);
		//ein SafeRoom
		Room saferoom = new SafeRoom(10.0, new Color(100, 20, 20), safeRoomDoors);
		
		//die Räume der hashMap rooms hinzufügen:
		rooms.put("Kitchen", kitchen);
		rooms.put("Bedroom", bedroom);
		rooms.put("Office", office);
		rooms.put("Saferoom", saferoom);
	}
	
	public void openFrontDoor(String code){
		frontdoor.open(code);
	}
	
	public void openSafeDoor(String code){
		this.safedoor.open(code);
	}
	
	//private HashMap<String,Room> rooms = new HashMap<>();
	public HashMap<String, Room> getRooms(){
		return this.rooms;
	}
	
	
	
	//das überwachte intelligente Hauptquartier kann eine Auflistung aller Räume zurückgeben
	public void printInfo(){
		System.out.println("Das Hauptquartier meldet sich:");
		System.out.println("Besitzer ist: " + this.getOwner().getFirstName() + " " + this.getOwner().getLastName()) ;
	}
	
	public void printRoomInfo(){
		Room room;	//nur eine Referenz auf einen Raum
		//über die Einträge im HashMap iterieren
		for (Entry<String, Room> e : rooms.entrySet()){
			room = e.getValue();
			System.out.println("Raum: " + e.getKey() + " " + room.toString());
		}		
	}
	
	//das überwachte intelligente Hauptquartier kann den Zustand aller Türen zurückgeben
	public void printDoorInfo(){
		Set<String> rooms_keyset = rooms.keySet();
		for(String room : rooms_keyset){
			for(Door door : rooms.get(room).doors){
				if(door.isOpen){
					System.out.println("Door in "+room+" is open." );					
				} else {
					System.out.println("Door in "+room+" is closed." );					
				}
			}
		}
	}
	
	//das überwachte intelligente Hauptquartier kann die Daten aller Sensoren zurückgeben
	public void printSensorInfo(){
		for(Sensorable s : listOfSensors){
			//System.out.println("Size ist: " + listOfSensors.size());
			System.out.println(s.getInfo());
		}
	}
}
