package tower;

import simulator.Coordinates;
import weather.WeatherProvider;

public class WeatherTower extends Tower {

	public String getWeather(Coordinates coordinates) {
		return (WeatherProvider.getInstance().getCurrentWeather(coordinates));
	}

	public void changeWeather() {
		this.conditionsChanged();
	}
}