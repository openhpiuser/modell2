package dukespackage;
//die Eingangstür ist eine Sicherheitstür
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
				System.out.println("Eingangstür offen");
				isOpen = false; //Tür wieder automatisch schließen
				FrontDoor.successfulEntered++;
			}
		}
		else{
			String str = "";
			str += lineSeparator;
			str += "Achtung: unberechtiger Zugriff an der Eingangstür" + lineSeparator;
			str += "Fehlgeschlagene Versuche die Tür zu öffnen: " + (attemptsToEnter-successfulEntered);
			str += lineSeparator;
			System.out.println(str);
		}
	}
	
	
}
