class WeatherProvider {
	private String[] weather;
	private static final WeatherProvider INSTANCE = new WeatherProvider();

	private WeatherProvider() {}

	public WeatherProvider getInstance() {
		return (INSTANCE);
	}

	public String getCurrentWeather(Coordinates p_Coordinates) {

	}
}