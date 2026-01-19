package app;

import java.io.FileOutputStream;
import java.io.PrintStream;

import simulator.AirportSimulator;
import simulator.Scenario;

public class Main {

	final static String SIMULATION_OUTPUT = "simulation.txt";

    public static void main(String[] args) {
		PrintStream originalOut = System.out;

        if (args.length != 1) {
            System.out.println("Invalid Argument.\nProgram Usage: ./avaj-launcher <file path>");
            return ;
        }

        try (PrintStream fileOut = new PrintStream(new FileOutputStream(SIMULATION_OUTPUT))){
			Scenario scenario = new Scenario(args[0]);

            System.setOut(fileOut);

			new AirportSimulator(scenario);

			System.setOut(originalOut);
        }
		catch (Exception e) {
            System.out.println("Error redirecting output.");
            return;
        }

		return ;
    }
}
