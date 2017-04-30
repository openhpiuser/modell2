package dukespackage;
//import java.security.acl.Owner;
public class Teddybear extends Interior implements Sensorable{
	MovementSensor movementSensor = new MovementSensor();
	Person owner;
	public Teddybear(Person owner){
		this.owner = owner;
	}
	@Override
	public void activate(boolean active) {
		movementSensor.setActive(true);;
		
	}
	@Override
	public void react() {
		sendMailWithSnapshotToOwner(owner);
		
	}
	private void sendMailWithSnapshotToOwner(Person owner) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getInfo() {
		if(movementSensor.isActive()){
			return "Teddies movementSensor is active";
		} else {
			return "Teddies movementSensor is not active";
		}
	}
}
