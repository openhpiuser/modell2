package dukespackage;
public abstract class Sensor {
	private boolean active = false;
	public boolean isActive(){
		return active;
	}
	public void setActive(boolean active){
		this.active = active;
	}
}
