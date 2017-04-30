package dukespackage;

import java.awt.Color;
import java.util.ArrayList;

public class SafeRoom extends Room  {

	public SafeRoom(double sizeInSquareMeter, Color wallColor, ArrayList<Door> doors) {
		super(sizeInSquareMeter, wallColor, doors);
		
	}
	
	public SafeRoom(double sizeInSquareMeter, Color wallColor, ArrayList<Door> doors, ArrayList<Interior> interior) {
		super(sizeInSquareMeter, wallColor, doors);
	}

}
