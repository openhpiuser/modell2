package dukespackage;
//die Eingangst�r ist eine Sicherheitst�r
public class FrontDoor extends SafetyDoor {
	protected static long attemptsToEnter = 0;
	protected static long successfulEntered = 0;
	final static String lineSeparator = System.getProperty("line.separator");
	
		
	//Konstruktor
	public FrontDoor(String code){
		this.code = code;
	}
	@Override
	public void open(String code) {
		FrontDoor.attemptsToEnter++;
		if(code.equals(this.code)){
			if(!isOpen){
				isOpen = true;
				System.out.println("Eingangst�r offen");
				isOpen = false; //T�r wieder automatisch schlie�en
				FrontDoor.successfulEntered++;
			}
		}
		else{
			String str = "";
			str += lineSeparator;
			str += "Achtung: unberechtiger Zugriff an der Eingangst�r" + lineSeparator;
			str += "Fehlgeschlagene Versuche die T�r zu �ffnen: " + (attemptsToEnter-successfulEntered);
			str += lineSeparator;
			System.out.println(str);
		}
	}
	
	
}
