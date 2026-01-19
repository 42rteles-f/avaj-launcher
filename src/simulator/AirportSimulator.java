package simulator;

import aircraft.AircraftFactory;
import aircraft.AircraftSpec;
import aircraft.Flyable;
import tower.WeatherTower;

public class AirportSimulator {
	private Scenario		scenario;
	private WeatherTower	weatherTower;

    public AirportSimulator(Scenario scenario) {
		this.setScenario(scenario);
		this.weatherTower = new WeatherTower();
		this.createAircrafts();
		this.run();
    }

	public void setScenario(Scenario scenario) {
		if (scenario == null) {
			return;
		}
		this.scenario = scenario;
	}

	public void run() {
		if (this.scenario == null) {
			System.out.println("Invalid scenario. Simulation cannot be started.");
			return;
		}
		if (this.weatherTower == null) {
			System.out.println("WeatherTower is not initialized. Simulation cannot be started.");
			return;
		}

		for (int i = 0; i < this.scenario.numberOfSimulations(); i++) {
			this.weatherTower.changeWeather();
		}
	}

	private void createAircrafts() {
		for (AircraftSpec spec : this.scenario.aircrafts()) {
			AircraftFactory.getInstance().newAircraft(
				spec.type,
				spec.name,
				new Coordinates(
					spec.longitude,
					spec.latitude,
					spec.height
				)
			).registerTower(this.weatherTower);
		}
	}
}
