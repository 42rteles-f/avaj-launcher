package weather;

public class WeatherProvider {
	private String[] weather = { "RAIN", "FOG", "SUN", "SNOW" };
	private static final WeatherProvider INSTANCE = new WeatherProvider();

	private WeatherProvider() {}

	public static WeatherProvider getInstance() {
		return (INSTANCE);
	}

	public String getCurrentWeather(Coordinates p_Coordinates) {
		return (this.weather[(p_Coordinates.getLongitude() + p_Coordinates.getLatitude() + p_Coordinates.getHeight()) % 4]);
	}
}