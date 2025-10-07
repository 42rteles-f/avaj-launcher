class Tower {
	private int height;
	private String material;
	private List<Flyable> observers = new ArrayList<>();

	public Tower(int height, String material) {
		this.height = height;
		this.material = material;
	}

	public int getHeight() {
		return height;
	}

	public String getMaterial() {
		return material;
	}
}