package washingmachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws TemperatureOutOfBoundsException {
		WashingMachine beko1 = new Beko();
		WashingMachine amica1 = new Amica();
		WashingMachine whirpool1 = new Whirpool();
		
		System.out.println("Excercise 1:");
		beko1.setProgram(20);
		beko1.showStatus();
		
		System.out.println();
		System.out.println("Excercise 2:");
		beko1.setProgram(20);
		beko1.nextProgram();
		beko1.showStatus();
		
		beko1.previousProgram();
		beko1.showStatus();
		
		System.out.println();
		System.out.println("Excercise 3:");
		amica1.setTemperature(50.5);
		amica1.showStatus();
		amica1.tempUp();
		amica1.tempDown();
		
		System.out.println();
		System.out.println("Excercise 4:");
		beko1.setTemperature(45.7);
		beko1.showStatus();
		amica1.setTemperature(34.9);
		amica1.showStatus();
		
		System.out.println();
		System.out.println("Excercise 5,6:");
		amica1.setTemperature(89.5);
		amica1.tempUp();
		
		try {
			amica1.tempUp();
		} catch (TemperatureOutOfBoundsException e) {
			System.out.println("Unable to change temperature!");
		}
		
		System.out.println();
		System.out.println("Excercise 7:");
		amica1.setV(800);
		amica1.showStatus();
		amica1.downV();
		amica1.showStatus();
		amica1.upV();
		amica1.showStatus();
		
		System.out.println();
		System.out.println("Excercise 8:");
		amica1.showStatus();
		
		System.out.println();
		System.out.println("Excercise 9:");
		System.out.println("Names of washingmachines: " + amica1.getNameMark() + " " + beko1.getNameMark() + " " + whirpool1.getNameMark());
		
		System.out.println();
		System.out.println("Excercise 10:");
		beko1.setTemperature(50.5);
		beko1.showStatus();
		beko1.tempUp();
		beko1.tempDown();
		
		System.out.println();
		System.out.println("Excercise 11:");
		whirpool1.setProgram(1);
		whirpool1.showStatus();
		whirpool1.previousProgram();
		whirpool1.showStatus();
		whirpool1.nextProgram();
		whirpool1.showStatus();
		
		System.out.println();
		System.out.println("Excercise 13:");
		List<WashingMachine> allWashingMachine = new ArrayList<>();
		allWashingMachine.add(new Beko());
		allWashingMachine.add(new Whirpool());
		allWashingMachine.add(new Amica());
		
		System.out.println("Washingmachines marks before sort: ");
		printAllWashingMachine(allWashingMachine);
		Collections.sort(allWashingMachine, (a, b) -> a.nameMark.toString()
				.compareTo(b.nameMark.toString()));
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
