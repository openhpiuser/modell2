package dukespackage;
public class NormalDoor extends Door {
	public NormalDoor(String material){
		this.material = material;
	}
	//eine normale T�r kann jederzeit ge�ffnet und geschlossen werden. evtl R�ckgabetyp boolean, wenn Zustand
	//erfolgreich ge�ndert wurde, nee besser nicht
	public void open(){
		if(!isOpen){ isOpen = true;}
	}
	public void close(){
		if(isOpen){	isOpen = false;	}
	} 
}
