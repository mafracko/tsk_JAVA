package washingmachine;

public class WashingMachine {
	
	protected NamesOfMarks	nameMark;
	protected int			maxProgram		= 20;
	protected int			numberOfProgram;
	protected double		temperature;
	protected double		maxTemperature	= 90;
	protected int			maxSpeedSpin	= 1000;
	protected int			speedSpin;
	protected double		temperatureJump	= 0.5;
	
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
	
	public void previousProgram() {
		if (numberOfProgram > 1) {
			setProgram(numberOfProgram - 1);
		} else {
			numberOfProgram = getMaxProgram();
		}
	}
	
	public void setTemperature(double temperature) {
		if (temperature >= 0 && temperature <= maxTemperature) {
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
	
	public void tempUp() throws TemperatureOutOfBoundsException {
		if (temperature <= maxTemperature - temperatureJump) {
			setTemperature(temperature + temperatureJump);
			System.out.println("Current temperature : " + temperature + "\u00b0" + "C");
		} else {
			throw new TemperatureOutOfBoundsException();
		}
	}
	
	public void tempDown() throws TemperatureOutOfBoundsException {
		if (temperature >= temperatureJump) {
			setTemperature(temperature - temperatureJump);
			System.out.println("Current temperature: " + temperature + "\u00b0" + "C");
		} else {
			throw new TemperatureOutOfBoundsException();
		}
		
	}
	
	public void setV(int speedSpin) {
		if (speedSpin >= 0 && speedSpin <= maxSpeedSpin) {
			this.speedSpin = speedSpin;
		}
	}
	
	public int getV() {
		return speedSpin;
	}
	
	public void upV() {
		if (speedSpin <= maxSpeedSpin - 100) {
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
	
	public int getMaxProgram() {
		return maxProgram;
	}
	
	public void setMaxProgram(int maxProgram) {
		this.maxProgram = maxProgram;
	}
	
}