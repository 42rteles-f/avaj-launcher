package app;

import java.io.FileOutputStream;
import java.io.PrintStream;

import exceptions.SimulationException;
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

        try (PrintStream fileOut = new PrintStream(new FileOutputStream(SIMULATION_OUTPUT))) {
            System.setOut(fileOut);
			new AirportSimulator(new Scenario(args[0]));
        }
		catch (SimulationException e) {
			System.setOut(originalOut);
			System.out.println("Simulation Exception: " + e.getMessage());
		}
		catch (Exception e) {
			System.setOut(originalOut);
			System.out.println("Exception: " + e.getMessage());
        }

		return ;
    }
}
