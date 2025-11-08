package tower;

import weather.Coordinates;

public class WeatherTower extends Tower {
	public String getWeather(Coordinates coordinates) {
		return "RAIN";
	}

	public void changeWeather() {
		this.conditionsChanged();
	}
}