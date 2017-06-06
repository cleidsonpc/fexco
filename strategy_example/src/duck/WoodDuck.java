package duck;

import behavior.flight.FlightBehaviorWood;
import behavior.sound.SoundBehaviorWood;

public class WoodDuck extends Duck {

	public WoodDuck() {
		super();
		setSound(new SoundBehaviorWood());
		setFlight(new FlightBehaviorWood());
	}
	
}
