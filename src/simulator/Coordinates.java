package simulator;

public class Coordinates {
	static final int MIN_COORDINATE_VALUE = 0;
	static final int MAX_COORDINATE_VALUE = 100;

	private int longitude;
	private int latitude;
	private int height;

	Coordinates(int p_longitude, int p_latitude, int p_height) {
		this.setAll(p_longitude, p_latitude, p_height);
	}

	public void setAll(int longitude, int latitude, int height) {
		this.longitude = this.validateValue(longitude);
		this.latitude = this.validateValue(latitude);
		this.height = this.validateValue(height);
	}

	private int validateValue(int value) {
		if (value < MIN_COORDINATE_VALUE)
			return (MIN_COORDINATE_VALUE);
		else if (value > MAX_COORDINATE_VALUE)
			return (MAX_COORDINATE_VALUE);
		return (int)value;
	}

	public int getLongitude() {
		return (this.longitude);
	}

	public int getLatitude() {
		return (this.latitude);
	}

	public int getHeight() {
		return (this.height);
	}

	public void adjustLongitude(int delta) {
		this.longitude = this.validateValue(this.longitude + delta);
	}

	public void adjustLatitude(int delta) {
		this.latitude = this.validateValue(this.latitude + delta);
	}

	public void adjustHeight(int delta) {
		this.height = this.validateValue(this.height + delta);
	}
}