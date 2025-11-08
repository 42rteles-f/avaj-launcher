package aircraft;

import weather.Coordinates;

public class JetPlane extends Aircraft {
	JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	public void updateConditions() {}

}