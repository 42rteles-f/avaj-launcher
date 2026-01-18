package tower;

import java.util.HashSet;
import java.util.Set;

import aircraft.Flyable;

public class Tower {
	private Set<Flyable> observers = new HashSet<>();
	private Set<Flyable> toRemove = new HashSet<>();

	public void register(Flyable p_flyable) {
		if (p_flyable == null) {
			System.out.println("Invalid Flyable object.");
			return;
		}

		this.observers.add(p_flyable);
		System.out.println(
			"Tower says: " + p_flyable.toString() + " registered to weather tower."
		);
	}

	public void unregister(Flyable p_flyable) {
		if (p_flyable != null) this.toRemove.add(p_flyable);
	}

	protected void conditionsChanged() {
		this.observers.forEach(ob -> ob.updateConditions());
		this.toRemove.forEach(ob -> {
			this.observers.remove(ob);
			System.out.println(
				"Tower says: " + ob.toString() + " unregistered from weather tower."
			);
		});
		this.toRemove.clear();
	}
}
