package weather;

public class Coordinates {
	static final byte MIN_COORDINATE_VALUE = 0;
	static final byte MAX_COORDINATE_VALUE = 100;

	private byte _longitude;
	private byte _latitude;
	private byte _height;

	public Coordinates(int longitude, int latitude, int height) {
		this.setAll(longitude, latitude, height);
	}

	public void setAll(int p_longitude, int p_latitude, int p_height) {
		this._longitude = this.validateValue(p_longitude);
		this._latitude = this.validateValue(p_latitude);
		this._height = this.validateValue(p_height);
	}

	private byte validateValue(int value) {
		if (value < MIN_COORDINATE_VALUE)
			return (MIN_COORDINATE_VALUE);
		else if (value > MAX_COORDINATE_VALUE)
			return (MAX_COORDINATE_VALUE);
		return (byte)value;
	}

	public byte longitude() {
		return (this._longitude);
	}

	public byte latitude() {
		return (this._latitude);
	}

	public byte height() {
		return (this._height);
	}

	public void adjustLongitude(int delta) {
		this._longitude = this.validateValue(this._longitude + delta);
	}

	public void adjustLatitude(int delta) {
		this._latitude = this.validateValue(this._latitude + delta);
	}

	public void adjustHeight(int delta) {
		this._height = this.validateValue(this._height + delta);
	}
}