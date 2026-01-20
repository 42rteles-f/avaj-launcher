package exceptions;

public class ScenarioArgumentException extends SimulationException {
	public ScenarioArgumentException(String message, int lineNumber) {
		super("Line " + lineNumber + ": " + message);
	}
}
