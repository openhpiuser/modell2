package dukespackage;
public class PressureSensor extends Sensor{
	public final static int DEFAULT_SENSITIVITY = 100;
	private int pressureSensitivity = 0;
	public int getPressureSensitivity() {
		return pressureSensitivity;
	}
	public void setPressureSensitivity(int pressureSensitivity) {
		this.pressureSensitivity = pressureSensitivity;
	}
}
