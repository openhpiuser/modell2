package dukespackage;
public abstract class Trap {
	private boolean trapped = false;
	private boolean sensor = false;
	public abstract void reset();
	public boolean isTrapped(){
		return trapped;
	}
	public boolean hasSensor(){
		return sensor;
	}
	public void setTrapped(boolean trapped){
		this.trapped = trapped;
	}
	public void setSensor(boolean sensor){
		this.sensor = sensor;
	}
}
