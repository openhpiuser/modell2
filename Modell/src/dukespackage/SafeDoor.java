package dukespackage;
public class SafeDoor extends SafetyDoor{
	protected static long attemptsToEnter = 0;
	protected static long successfulEntered = 0;
	final static String lineSeparator = System.getProperty("line.separator");
		
	//Konstruktor
	public SafeDoor(String code){
		this.code = code;
	}
	@Override
	public void open(String code) {
		SafeDoor.attemptsToEnter++;
		if(code.equals(this.code)){
			if(!isOpen){
				isOpen = true;
				System.out.println("Methode open der Klasse SafeDoor meldet: SafeDoor offen");
				isOpen = false; //Tür wieder automatisch schließen
				SafeDoor.successfulEntered++;
			}
		}
		else{
			String str = "";
			str += lineSeparator;
			str += "Achtung: unberechtiger Zugriff an der SafeDoor" + lineSeparator;
			str += "Fehlgeschlagene Versuche den Safe zu öffnen: " + (attemptsToEnter-successfulEntered);
			str += lineSeparator;
			System.out.println(str);
		}
	}
}
