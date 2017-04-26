package dukespackage;
//die Eingangstür ist eine Sicherheitstür
public class FrontDoor extends SafetyDoor {
	//Konstruktor
	public FrontDoor(String code){
		this.code = code;
	}
	@Override
	public void open(String code) {
		if(code.equals(this.code)){
			if(!isOpen){ isOpen = true;}
		}
	}
}
