public class Main {

    void getFileInfo(String fileName) {

    }

    public static int Main(String[] args) {
        if (args.length != 1) {
            System.out.println("Invalid Argument.\nProgram Usage: ./avaj-launcher <file path>");
            return (1);
        }

        final AirportSimulator simulation = new AirportSimulator(args[0]);
		return (0);
    }
}
