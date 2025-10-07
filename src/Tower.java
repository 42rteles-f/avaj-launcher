import java.util.ArrayList;
import java.util.List;

class Tower {
	private List<Flyable> observers = new ArrayList<>();

	public void register(Flyable p_flyable) {
		if (!this.observers.contains(p_flyable))
			this.observers.add(p_flyable);
	}

	public void unregister(Flyable p_flyable) {
		this.observers.remove(p_flyable);
	}

	protected void conditionsChanged() {
		this.observers.forEach(ob -> ob.updateConditions());
	}
}