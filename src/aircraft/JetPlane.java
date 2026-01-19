package aircraft;

import simulator.Coordinates;

public class JetPlane extends Aircraft {

	JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}
	
	@Override
	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
		switch (weather) {
			case "SUN" -> {
				this.coordinates.adjustLatitude(10);
				this.coordinates.adjustHeight(2);
				System.out.println(this.toString() + ": It's sunny. Perfect day for a Jet away.");
			}
			case "RAIN" -> {
				this.coordinates.adjustLatitude(5);
				System.out.println(this.toString() + ": Cutting rain like a knife in the sky.");
			}
			case "FOG" -> {
				this.coordinates.adjustLatitude(1);
				System.out.println(this.toString() + ": Fog confirmed, approaching unsuspecting enemy.");
			}
			case "SNOW" -> {
				this.coordinates.adjustHeight(-7);
				System.out.println(this.toString() + ": Snow confirmed, entering Russian airspace.");
			}
		};

		if (this.coordinates.getHeight() < 1)
			this.land();
	}
}