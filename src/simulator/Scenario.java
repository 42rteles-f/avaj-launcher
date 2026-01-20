package simulator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import aircraft.AircraftSpec;
import exceptions.ScenarioArgumentException;
import exceptions.ScenarioFileException;
import exceptions.SimulationException;

public class Scenario {

	private int 					_numberOfSimulations;
	private List<AircraftSpec>		_aircrafts = new ArrayList<>();
	private final static String[]	_validAircraftTypes = { "Balloon", "Helicopter", "JetPlane" };

	public Scenario(String filePath) throws IOException, SimulationException {
		if ( filePath == null || filePath.isEmpty() ) {
			throw new ScenarioFileException("Error: File path is null or empty.");
		}
		if (Files.notExists(Path.of(filePath))) {
			throw new ScenarioFileException("Error: File does not exist at the specified path.");
		}
		this.parseFile(filePath);
		this.validateScenario(filePath);
	}

	private void parseFile(String filePath) throws IOException, SimulationException {
		List<String> lines = Files.readAllLines(Path.of(filePath));
		if (lines.size() < 2) {
			throw new ScenarioFileException("Error: Scenario file is invalid or incomplete.");
		}

		this._numberOfSimulations = Integer.parseInt(lines.get(0));

		for (int i = 1; i < lines.size(); i++)
		{
			String[] parts = lines.get(i).split(" ");
			if (parts.length != 5) {
				throw new ScenarioArgumentException("Error: Invalid aircraft specification", (i + 1));
			}

			AircraftSpec spec = new AircraftSpec();
			spec.type = parts[0];
			spec.name = parts[1];
			spec.longitude = Integer.parseInt(parts[2]);
			spec.latitude = Integer.parseInt(parts[3]);
			spec.height = Integer.parseInt(parts[4]);
			this._aircrafts.add(spec);
		}
	}

	public void validateScenario(String filePath) throws SimulationException {
		if (this._numberOfSimulations <= 0) {
			throw new ScenarioArgumentException("Error: Number of simulations must be a positive integer.", 0);
		}
		if (this._aircrafts.isEmpty()) {
			throw new ScenarioArgumentException("Error: No aircraft specifications found.", 0);
		}
		for (int i = 0; i < _aircrafts.size(); i++) {
			AircraftSpec spec = _aircrafts.get(i);
			if (spec.type == null || spec.name == null || !Arrays.asList(_validAircraftTypes).contains(spec.type)) {
				throw new ScenarioArgumentException("Error: Aircraft type or name is invalid.", (i + 2));
			}
			if (spec.longitude < 0 || spec.latitude < 0) {
				throw new ScenarioArgumentException("Error: Aircraft coordinates are invalid.", (i + 2));
			}
		}
	}

	public int numberOfSimulations() {
		return (this._numberOfSimulations);
	}

	public List<AircraftSpec> aircrafts() {
		return (this._aircrafts);
	}
}
