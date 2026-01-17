package aircraft;

import weather.Coordinates;

public class Aircraft extends Flyable {
	protected long			id;
	protected String		name;
	protected Coordinates	coordinates;

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_coordinates;
	}

	@Override
	public void updateConditions() {}

	public void land() {
		if (this.weatherTower == null) {
			System.out.println("Error: weatherTower is null in land()");
			return ;
		}

		System.out.println(this.toString() + " landing.");
		this.weatherTower.unregister(this);
	}

	@Override
	public String toString() {
		return String.format("%s#%s(%d)", this.getClass().getSimpleName(), this.name, this.id);
	}
}

