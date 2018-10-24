package washingmachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws TemperatureOutOfRangeException {
		WashingMachine beko = new Beko();
		WashingMachine amica = new Amica();
		WashingMachine whirpool = new Whirpool();
		
		System.out.println("Excercise 1:");
		beko.setProgram(20);
		beko.showStatus();
		
		System.out.println();
		System.out.println("Excercise 2:");
		beko.setProgram(20);
		beko.nextProgram();
		beko.showStatus();
		
		beko.previousProgram();
		beko.showStatus();
		
		System.out.println();
		System.out.println("Excercise 3:");
		amica.setTemperature(50.5);
		amica.showStatus();
		amica.tempUp();
		amica.tempDown();
		
		System.out.println();
		System.out.println("Excercise 4:");
		beko.setTemperature(45.7);
		beko.showStatus();
		amica.setTemperature(34.9);
		amica.showStatus();
		
		System.out.println();
		System.out.println("Excercise 5,6:");
		amica.setTemperature(89.5);
		amica.tempUp();
		
		try {
			amica.tempUp();
		} catch (TemperatureOutOfRangeException e) {
			System.out.println(e.getMessage());
			System.out.println("Unable to change temperature over 90" + "\u00b0" + "C");
		}
		amica.setTemperature(0.0);
		try {
			amica.tempDown();
		} catch (TemperatureOutOfRangeException e) {
			System.out.println(e.getMessage());
			System.out.println("Unable to change temperature below 0" + "\u00b0" + "C");
		}
		
		System.out.println();
		System.out.println("Excercise 7:");
		amica.setV(0);
		amica.showStatus();
		amica.downV();
		amica.showStatus();
		amica.upV();
		amica.showStatus();
		
		System.out.println();
		System.out.println("Excercise 8:");
		
		amica.showStatus();
		
		System.out.println();
		System.out.println("Excercise 9:");
		System.out.println("Names of washingmachines: " + amica.getNameMark() + ", " + beko.getNameMark() + ", " + whirpool.getNameMark());
		
		System.out.println();
		System.out.println("Excercise 10:");
		beko.setTemperature(50.5);
		beko.showStatus();
		beko.tempUp();
		beko.tempDown();
		
		System.out.println();
		System.out.println("Excercise 11:");
		whirpool.setProgram(1);
		whirpool.showStatus();
		whirpool.previousProgram();
		whirpool.showStatus();
		whirpool.nextProgram();
		whirpool.showStatus();
		
		System.out.println();
		System.out.println("Excercise 13:");
		
		List<WashingMachine> allWashingMachine = new ArrayList<>();
		allWashingMachine.add(new Beko());
		allWashingMachine.add(new Whirpool());
		allWashingMachine.add(new Amica());
		
		System.out.println("Washingmachines marks before sort: ");
		printAllWashingMachine(allWashingMachine);
		Collections.sort(allWashingMachine, (a, b) -> a.getNameMark()
				.toString()
				.compareTo(b.getNameMark()
						.toString()));
		System.out.println("Washingmachines marks after sort: ");
		printAllWashingMachine(allWashingMachine);
	}
	
	public static void printAllWashingMachine(List<WashingMachine> washingmachine) {
		washingmachine.stream()
				.forEach((el) -> {
					System.out.println(el.getNameMark());
				});
	}
}
