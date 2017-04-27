package dukespackage;

//auf eine Ableitung von Vogel wird verzichtet,
//da der Focus auf der Modellierung des Hauptquartiers liegt
public class Parrot implements Flyable {
	private String name = "";
	public Parrot(String name){
		this.name = name;
	}
	
	public void fly(){
        System.out.println("Parrot kann fliegen");
	}
	

}
