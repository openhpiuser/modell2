package dukespackage;
public abstract class SafetyDoor extends Door {
	protected String code = "";
	public abstract void open(String code);
}
