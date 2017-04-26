package dukespackage;
public class NormalDoor extends Door {
	public NormalDoor(String material){
		this.material = material;
	}
	//eine normale Tür kann jederzeit geöffnet und geschlossen werden. evtl Rückgabetyp boolean, wenn Zustand
	//erfolgreich geändert wurde, nee besser nicht
	public void open(){
		if(!isOpen){ isOpen = true;}
	}
	public void close(){
		if(isOpen){	isOpen = false;	}
	} 
}
