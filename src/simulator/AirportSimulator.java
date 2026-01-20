package simulator;

import java.util.List;

import aircraft.AircraftFactory;
import aircraft.AircraftSpec;
import exceptions.SimulationException;
import tower.WeatherTower;

public class AirportSimulator {
	private WeatherTower	weatherTower;

    public AirportSimulator(Scenario scenario) throws SimulationException {
		if (scenario == null) {
			throw new IllegalArgumentException("Scenario cannot be null.");
		}
		this.weatherTower = new WeatherTower();
		this.createAircrafts(scenario.aircrafts());
		this.run(scenario.numberOfSimulations());
    }

	private void createAircrafts(List<AircraftSpec> aircraftSpecs) throws SimulationException {
		for (AircraftSpec spec : aircraftSpecs)
		{
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

	public void run(int numberOfSimulations) {
		if (this.weatherTower == null) {
			System.out.println("WeatherTower is not initialized. Simulation cannot be started.");
			return;
		}

		for (int i = 0; i < numberOfSimulations; i++) {
			this.weatherTower.changeWeather();
		}
	}
}
