package dukespackage;
import java.awt.Color;
import java.util.ArrayList;
public class Bedroom extends Room {
	public Bedroom(double sizeInSquareMeter, Color wallColor, ArrayList<Door> doors) {
		super(sizeInSquareMeter, wallColor, doors);
	}
	
	public Bedroom(double sizeInSquareMeter, Color wallColor, ArrayList<Door> doors, ArrayList<Interior> interior) {
		super(sizeInSquareMeter, wallColor, doors);
	}
}
