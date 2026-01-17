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
				this.coordinates.adjustLongitude(10);
				this.coordinates.adjustHeight(2);
				System.out.println(this.toString() + ": Love the wind on Sunny days!");
			}
			case "RAIN" -> {
				this.coordinates.adjustLongitude(5);
				System.out.println(this.toString() + ": This rain is jeopardazing the rescue mission!");
			}
			case "FOG" -> {
				this.coordinates.adjustLongitude(1);
				System.out.println(this.toString() + ": We cant follow Rambo in the Fog!");
			}
			case "SNOW" -> {
				this.coordinates.adjustHeight(-12);
				System.out.println(this.toString() + ": Freeze failure! Abort!");
			}
		};

		if (this.coordinates.height() <= 0)
			this.land();
	}
}
