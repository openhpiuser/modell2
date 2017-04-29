package dukespackage;
import java.awt.Color;
import java.util.ArrayList;
public abstract class Room {
/*
 * die Bezeichnung des Raumes wird beim Bau des HeadQuaters in der HashMap vergeben, 
 * die Funktion des Raums kann sich auch aendern, daher wird hier kein Attribut roomName benutzt
 * außerdem müssten dann das Attribut roomname und der key in der HashMap immer synchron gehalten werden.
 * 
 */
	//protected String roomName = ""; 
	protected double sizeInSquareMeter = 0;
	protected Color wallColor = new Color(255,255,255);
	protected ArrayList<Door> doors = new ArrayList<>();
	//Ein Raum soll mindestens 1 Tür haben, der Typ wird allgemein gehalten.
	protected ArrayList<Interior> interior = new ArrayList<>();
	
	//Konstruktor
	public Room(double sizeInSquareMeter, Color wallColor, ArrayList<Door> doors ){
		this.sizeInSquareMeter = sizeInSquareMeter;
		this.wallColor = wallColor;
		this.doors = doors;
		//noch zu tun, hier sollte  wirklich kopiert werden,
		//sonst sind die Türen weg, wenn die Objekte gelöscht werden
	}
	
	public Room(double sizeInSquareMeter, Color wallColor, ArrayList<Door> doors, ArrayList<Interior> interior ){
		this.sizeInSquareMeter = sizeInSquareMeter;
		this.wallColor = wallColor;
		this.doors = doors;
		//noch zu tun, hier sollte  wirklich kopiert werden,
		//sonst sind die Türen weg, wenn die Objekte gelöscht werden
		
		this.interior = interior;
	}
	
	@Override
	public String toString(){
		String str = new String();
		str += "Groesse: " + sizeInSquareMeter + " qm " 
				+ "Farbe: " + "[" + wallColor.getRed() 
				+ "," + wallColor.getGreen() + "," 
				+  wallColor.getBlue() +"]";
		return str;
	}
}
