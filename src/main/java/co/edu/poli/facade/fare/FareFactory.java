package co.edu.poli.facade.fare;

import co.edu.poli.model.Vehicle;

public class FareFactory {
	
	public Fare evaluateFare(Vehicle vehicle) {		
		if (vehicle.getType() == "car") {
			return new CarFare();
		} else if (vehicle.getType() == "motorcycle") {
			return new MotorcycleFare();
		} else {
			System.out.println("Not supported vehicle");
			return null;
		}
	}

}
