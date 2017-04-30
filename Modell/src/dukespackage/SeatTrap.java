package dukespackage;

public class SeatTrap extends Trap implements Sensorable {
	PressureSensor pressureSensor = new PressureSensor();
	DropOffGas dropOffGas = new DropOffGas();
	private int pressure = 0;
	
	public int getPressure() {
		return pressure;
	}


	public void setPressure(int pressure) {
		this.pressure = pressure;
	}


	public SeatTrap(){
		setSensor(true);
		pressureSensor.setActive(true);
		pressureSensor.setPressureSensitivity(PressureSensor.DEFAULT_SENSITIVITY);
		setTrapped(false);
	}
	
	
	@Override
	public void activate(boolean active) {
		pressureSensor.setActive(active);
		
	}

	@Override
	public void react() {
		if(pressureSensor.isActive() && pressure > pressureSensor.getPressureSensitivity()){
			dropOffGas.releaseGas();
			dropOffGas.setReleased(true);
			setTrapped(true);
		} else {
			System.out.println("Trapsensor not active!");
		}	
	}


	@Override
	public void reset() {
		setSensor(true);
		pressureSensor.setActive(true);
		pressureSensor.setPressureSensitivity(PressureSensor.DEFAULT_SENSITIVITY);
		setTrapped(false);
		
		if(dropOffGas.isReleased()){
			dropOffGas.fillGas();
		}
		
	}


	@Override
	public String getInfo() {
		if(pressureSensor.isActive()){
			return "SeatTraps pressureSensor is active";
		}
		return "SeatTraps pressureSensor is not active";
	}

}
