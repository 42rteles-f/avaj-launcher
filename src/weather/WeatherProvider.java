package weather;

import simulator.Coordinates;

public class WeatherProvider {
	private static final WeatherProvider INSTANCE = new WeatherProvider();

	private String[]		weather = { "SUN", "RAIN", "FOG", "SNOW" };

	private WeatherProvider() {}

	public static WeatherProvider getInstance() {
		return (INSTANCE);
	}

	public String getCurrentWeather(Coordinates p_Coordinates) {
		return (this.weather[
			(p_Coordinates.getLongitude() + p_Coordinates.getLatitude() + p_Coordinates.getHeight()) % 4
		]);
	}
}