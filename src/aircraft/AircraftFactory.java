package aircraft;

import exceptions.SimulationException;
import simulator.Coordinates;

public class AircraftFactory {
	private static final AircraftFactory INSTANCE = new AircraftFactory();
	private static long idCounter = 1;

	private AircraftFactory() {}

	public static AircraftFactory getInstance() {
		return (INSTANCE);
	}

	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) throws SimulationException {
		if		(p_type.equals("Balloon"))		return (new Balloon(idCounter++, p_name, p_coordinates));
		else if (p_type.equals("Helicopter"))	return (new Helicopter(idCounter++, p_name, p_coordinates));
		else if (p_type.equals("JetPlane"))		return (new JetPlane(idCounter++, p_name, p_coordinates));
		else									throw new SimulationException("newAircraft(): Error: Unknown aircraft type '" + p_type + "'.");
	}
}