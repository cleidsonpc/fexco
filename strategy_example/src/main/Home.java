package main;

import behavior.flight.FlightBehaviorDefault;
import behavior.sound.SoundBehaviorRubber;
import duck.Duck;
import duck.NaturalDuck;
import duck.RubberDuck;
import duck.WoodDuck;

public class Home {
	
	public static void main(String[] args) {
		
		System.out.println("--Wood duck--");
		Duck pm = new WoodDuck();
		pm.getSound().sound();
		pm.getFlight().flight();
		
		System.out.println("--Rubber duck--");
		Duck pb = new RubberDuck();
		pb.getSound().sound();
		pb.getFlight().flight();
		
		System.out.println("--Natural duck--");
		Duck pc = new NaturalDuck();
		pc.getSound().sound();
		pc.getFlight().flight();
		
		// Strategy (To change the behavior during the execution)
		System.out.println("--Wood duck (changed)--");
		pm.setSound(new SoundBehaviorRubber());
		pm.setFlight(new FlightBehaviorDefault());
		pm.getSound().sound();
		pm.getFlight().flight();
		
	}
	
}
