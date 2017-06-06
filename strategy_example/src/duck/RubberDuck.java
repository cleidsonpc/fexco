package duck;

import behavior.flight.FlightBehaviorRubber;
import behavior.sound.SoundBehaviorRubber;

public class RubberDuck extends Duck {

	public RubberDuck() {
		super();
		setSound(new SoundBehaviorRubber());
		setFlight(new FlightBehaviorRubber());
	}
	
}
