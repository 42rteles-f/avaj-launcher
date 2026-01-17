package tower;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import aircraft.Flyable;

public class Tower {
	private Set<Flyable> observers = new HashSet<>();

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
		this.observers.remove(p_flyable);
		System.out.println(
			"Tower says: " + p_flyable.toString() + " unregistered from weather tower."
		);
	}

	protected void conditionsChanged() {
		this.observers.forEach(ob -> ob.updateConditions());
	}
}