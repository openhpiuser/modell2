package dukespackage;
public class SafeDoor extends SafetyDoor{
	@Override
	public void open(String code) {
		if(code.equals(this.code)){
			if(!isOpen){ isOpen = true;}
		}
		//additional functionality
	} 
}
