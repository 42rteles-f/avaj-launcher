package app;
import java.io.FileOutputStream;
import java.io.PrintStream;

import simulator.*;

public class Main {

	final static String SIMULATION_OUTPUT = "simulation.txt";

    public static void main(String[] args) {
		PrintStream originalOut = System.out;
        PrintStream fileOut = null;

        if (args.length != 1) {
            System.out.println("Invalid Argument.\nProgram Usage: ./avaj-launcher <file path>");
            return ;
        }

        try {
			Scenario scenario = new Scenario(args[0]);

			fileOut = new PrintStream(new FileOutputStream(SIMULATION_OUTPUT));
            System.setOut(fileOut);

			new AirportSimulator(scenario);

			System.setOut(originalOut);
			if (fileOut != null) fileOut.close();
        }
		catch (Exception e) {
            System.out.println("Error redirecting output.");
            return;
        }

		return ;
    }
}
