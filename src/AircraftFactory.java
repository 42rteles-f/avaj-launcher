class AircraftFactory {
	private static final AircraftFactory INSTANCE = new AircraftFactory();

	private AircraftFactory() {}

	public static AircraftFactory getInstance() {
		return (INSTANCE);
	}

	public Aircraft createAircraft() {

	}
}