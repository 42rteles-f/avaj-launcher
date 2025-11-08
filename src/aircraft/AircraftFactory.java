package aircraft;

import weather.Coordinates;

public class AircraftFactory {
	private static final AircraftFactory INSTANCE = new AircraftFactory();
	private static long idCounter = 0;

	private AircraftFactory() {}

	public static AircraftFactory getInstance() {
		return (INSTANCE);
	}
	public Aircraft newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
		if (p_type.equals("Baloon"))
			return (new Baloon(idCounter++, p_name, p_coordinates));
		else if (p_type.equals("Helicopter"))
			return (new Helicopter(idCounter++, p_name, p_coordinates));
		else if (p_type.equals("JetPlane"))
			return (new JetPlane(idCounter++, p_name, p_coordinates));
		else
			return (null);
	}
}