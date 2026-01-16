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
		this.weatherTower.unregister(this);
		System.out.printf("%s#%s(%d) landing at coordinates [%d, %d, %d]%n",
			this.getClass().getSimpleName(),
			this.name,
			this.id,
			this.coordinates.longitude(),
			this.coordinates.latitude(),
			this.coordinates.height());
	}
}

