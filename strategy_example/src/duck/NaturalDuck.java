package duck;

import behavior.flight.FlightBehaviorDefault;
import behavior.sound.SoundBehaviorDefault;

public class NaturalDuck extends Duck {

	public NaturalDuck() {
		super();
		setSound(new SoundBehaviorDefault());
		setFlight(new FlightBehaviorDefault());
		
	}
	
}
