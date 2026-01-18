package aircraft;

import weather.Coordinates;

public class Balloon extends Aircraft {

	Balloon(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	@Override
	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
		switch (weather) {
			case "SUN" -> {
				this.coordinates.adjustLongitude(2);
				this.coordinates.adjustHeight(4);
				System.out.println(this.toString() + ": Sun's out, get the champagne!");
			}
			case "RAIN" -> {
				this.coordinates.adjustHeight(-5);
				System.out.println(this.toString() + ": Raining! Should have checked the weather!");
			}
			case "FOG" -> {
				this.coordinates.adjustHeight(-3);
				System.out.println(this.toString() + ": I actually enjoy the view with a little Fog.");
			}
			case "SNOW" -> {
				this.coordinates.adjustHeight(-15);
				System.out.println(this.toString() + ": Is it dangerous to balloon on Snow days? 🥶");
			}
		};

		if (this.coordinates.height() < 1)
			this.land();
	}

}