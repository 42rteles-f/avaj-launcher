package aircraft;

import weather.Coordinates;

public class JetPlane extends Aircraft {

	JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}
	
	@Override
	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
		switch (weather) {
			case "SUN" -> {
				this.coordinates.incrementLatitude(10);
				this.coordinates.incrementHeight(2);
			}
			case "RAIN" -> {
				this.coordinates.incrementLatitude(5);
			}
			case "FOG" -> {
				this.coordinates.incrementLatitude(1);
			}
			case "SNOW" -> {
				this.coordinates.incrementHeight(-7);
			}
		};

		if (this.coordinates.height() < 1)
			this.land();
	}
}