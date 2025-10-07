class Aircraft {
	private String model;
	private int maxSpeed;
	private int range;
	private int price;

	public Aircraft(String model, int maxSpeed, int range, int price) {
		this.model = model;
		this.maxSpeed = maxSpeed;
		this.range = range;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public int getRange() {
		return range;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Model: " + model + ", Max Speed: " + maxSpeed + " km/h, Range: " + range + " km, Price: $" + price;
	}
}