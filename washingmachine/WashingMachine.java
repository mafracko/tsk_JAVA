package washingmachine;

public abstract class WashingMachine {
	
	private static final double	MAX_TEMPERATURE	= 90;
	private static final int	MAX_SPEED_SPIN	= 1000;
	private NamesOfMarks		nameMark;
	protected int				maxProgram		= 20;
	private int					numberOfProgram	= 1;
	protected double			temperatureJump	= 0.5;
	private double				temperature;
	private int					speedSpin;
	
	public WashingMachine(NamesOfMarks namesOfMarks) {
		this.nameMark = namesOfMarks;
	}
	
	public NamesOfMarks getNameMark() {
		return nameMark;
	}
	
	public void setProgram(int numberOfProgram) {
		if (numberOfProgram > 0 && numberOfProgram <= getMaxProgram()) {
			this.numberOfProgram = numberOfProgram;
		}
	}
	
	public int getProgram() {
		return numberOfProgram;
	}
	
	public void nextProgram() {
		if (numberOfProgram < getMaxProgram()) {
			setProgram(numberOfProgram + 1);
		} else {
			numberOfProgram = 1;
		}
		
	}
	
	public int getMaxProgram() {
		return maxProgram;
	}
	
	public void setMaxProgram(int maxProgram) {
		this.maxProgram = maxProgram;
	}
	
	public void previousProgram() {
		if (numberOfProgram > 1) {
			setProgram(numberOfProgram - 1);
		} else {
			numberOfProgram = getMaxProgram();
		}
	}
	
	public void setTemperature(double temperature) {
		if (temperature >= 0 && temperature <= MAX_TEMPERATURE) {
			this.temperature = Math.round(temperature * 2) / 2.0;
		}
	}
	
	public double getTemperature() {
		return temperature;
	}
	
	public double getTemperatureJump() {
		return temperatureJump;
	}
	
	public void setTemperatureJump(double temperatureJump) {
		this.temperatureJump = temperatureJump;
	}
	
	public void tempUp() throws TemperatureOutOfRangeException {
		if (temperature <= MAX_TEMPERATURE - temperatureJump) {
			setTemperature(temperature + temperatureJump);
			System.out.println("Current temperature : " + temperature + "\u00b0" + "C");
		} else {
			throw new TemperatureOutOfRangeException();
		}
	}
	
	public void tempDown() throws TemperatureOutOfRangeException {
		if (temperature >= temperatureJump) {
			setTemperature(temperature - temperatureJump);
			System.out.println("Current temperature: " + temperature + "\u00b0" + "C");
		} else {
			throw new TemperatureOutOfRangeException();
		}
		
	}
	
	public void setV(int speedSpin) {
		if (speedSpin >= 0 && speedSpin <= MAX_SPEED_SPIN) {
			this.speedSpin = speedSpin;
		}
	}
	
	public int getV() {
		return speedSpin;
	}
	
	public void upV() {
		if (speedSpin <= MAX_SPEED_SPIN - 100) {
			setV(speedSpin + 100);
		} else
			speedSpin = 0;
	}
	
	public void downV() {
		if (speedSpin >= 100) {
			setV(speedSpin - 100);
		} else {
			speedSpin = 1000;
		}
	}
	
	public void showStatus() {
		System.out.println("Washingmachine mark: " + nameMark + ", number of program: " + numberOfProgram + ", temperature: " + temperature + ", speedspin: " + speedSpin + ".");
		
	}
	
}