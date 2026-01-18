package app;
import java.io.FileOutputStream;
import java.io.PrintStream;

import simulator.*;

public class Main {

    public static void main(String[] args) {
		PrintStream originalOut = System.out;
        PrintStream fileOut = null;

        if (args.length != 1) {
            System.out.println("Invalid Argument.\nProgram Usage: ./avaj-launcher <file path>");
            return ;
        }
        try {
            fileOut = new PrintStream(new FileOutputStream("simulation.txt"));
            System.setOut(fileOut);
        } catch (Exception e) {
            System.out.println("Error redirecting output.");
            return;
        }

		new AirportSimulator(new Scenario(args[0]));

		System.setOut(originalOut);
		if (fileOut != null) {
			fileOut.flush();
			fileOut.close();
		}
		
		return ;
    }
}
