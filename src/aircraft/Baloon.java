package aircraft;

import weather.Coordinates;

public class Baloon extends Aircraft {

	Baloon(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	@Override
	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
		switch (weather) {
			case "SUN" -> {
				this.coordinates.incrementLongitude(2);
				this.coordinates.incrementHeight(4);
			}
			case "RAIN" -> {
				this.coordinates.incrementHeight(-5);
			}
			case "FOG" -> {
				this.coordinates.incrementHeight(-3);
			}
			case "SNOW" -> {
				this.coordinates.incrementHeight(-15);
			}
		};

		if (this.coordinates.height() < 1)
			this.land();
	}

}