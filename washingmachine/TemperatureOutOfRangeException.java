package washingmachine;

public class TemperatureOutOfRangeException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public TemperatureOutOfRangeException() {
		super("Temperature out of range");
	}
}
