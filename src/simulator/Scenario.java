package simulator;

import aircraft.AircraftSpec;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Scenario {

	private int 				_numberOfSimulations;
	private List<AircraftSpec>	_aircrafts = new ArrayList<>();
	private Boolean				_isValid = false;

	public Scenario(String filePath) {
		if ( filePath == null || filePath.isEmpty() ) {
			this._isValid = false;
			return ;
		}
		this.validateScenario(filePath);
	}

	public Boolean validateScenario(String filePath) {
		if (!this.parseFile(filePath)) {
			return (this._isValid = false);
		}
		if (this._numberOfSimulations <= 0) {
			System.out.println("Error: Invalid number of simulations.");
			return (this._isValid = false);
		}
		if (this._aircrafts.isEmpty()) {
			System.out.println("Error: No aircraft specifications found.");
			return (this._isValid = false);
		}
		for (AircraftSpec spec : this._aircrafts) {
			if (spec.type == null || spec.name == null) {
				System.out.println("Error: Aircraft type or name is missing.");
				return (this._isValid = false);
			}
		}
		return (this._isValid = true);
	}

	private Boolean parseFile(String filePath) {
		try {
			List<String> lines = Files.readAllLines(Path.of(filePath));
			if (lines.size() < 2) {
				throw new IllegalArgumentException("Error: Scenario file is invalid or incomplete.");
			}

			this._numberOfSimulations = Integer.parseInt(lines.get(0));

			for (int i = 1; i < lines.size(); i++)
			{
				String[] parts = lines.get(i).split(" ");
				if (parts.length != 5) {
					throw new IllegalArgumentException("Error: Invalid aircraft specification at line " + (i + 1));
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
		catch (IOException e) {
			e.printStackTrace();
			this.clearScenario();
			return (false);
		}
		return (true);
	}

	private void	clearScenario() {
		this._numberOfSimulations = 0;
		this._aircrafts.clear();
		this._isValid = false;
	}

	public Boolean isValid() {
		return (this._isValid);
	}

	public int numberOfSimulations() {
		return (this._numberOfSimulations);
	}

	public List<AircraftSpec> aircrafts() {
		return (this._aircrafts);
	}
}
