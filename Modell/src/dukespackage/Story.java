package dukespackage;
public class Story {
	public static void main(String[] args) {
		Person eike = new Person("Eike", "Vil");
		Headquarters eikesHeadquarters = new Headquarters(eike);
		eikesHeadquarters.printRoomList();
	}
}
