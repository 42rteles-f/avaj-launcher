package tower;

import java.util.ArrayList;
import java.util.List;

import aircraft.Flyable;

public class Tower {
	private List<Flyable> observers = new ArrayList<>();

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
		if (p_flyable == null) return ;

		this.observers.remove(p_flyable);
		System.out.println(
			"Tower says: " + p_flyable.toString() + " unregistered from weather tower."
		);
	}

	protected void conditionsChanged() {
		(new ArrayList<>(this.observers)).forEach(Flyable::updateConditions);
	}
}
