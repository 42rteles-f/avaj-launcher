import simulation.AirportSimulator;

package src;

public class Main {

    void getFileInfo(String fileName) {

    }

    public static void Main(String[] args) {
        if (args.length != 1) {
            system.out.print("Invalid Argument.\nProgram Usage: ./avaj-launcher <file path>");
            return (1);
        }

        const AirportSimulator simulation = new AirportSimulator(args[0]);

        
    }
}
