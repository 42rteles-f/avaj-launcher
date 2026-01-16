package aircraft;

import weather.Coordinates;

public class Helicopter extends Aircraft {

	public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	@Override
	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
		switch (weather) {
			case "SUN" -> {
				this.coordinates.incrementLongitude(10);
				this.coordinates.incrementHeight(2);
			}
			case "RAIN" -> {
				this.coordinates.incrementLongitude(5);
			}
			case "FOG" -> {
				this.coordinates.incrementLongitude(1);
			}
			case "SNOW" -> {
				this.coordinates.incrementHeight(-12);
			}
		};

		if (this.coordinates.height() <= 0)
			this.land();
	}
}
