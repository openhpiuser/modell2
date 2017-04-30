package dukespackage;
//auf eine Ableitung von Vogel wird verzichtet,
//da der Focus auf der Modellierung des Hauptquartiers liegt
public class Parrot implements Flyable {
	public Parrot(String firstName, String lastName){
	}
	public void fly(){
        System.out.println("Parrot kann fliegen");
	}
}
