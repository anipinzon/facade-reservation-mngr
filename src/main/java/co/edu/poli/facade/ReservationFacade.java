package co.edu.poli.facade;

import co.edu.poli.facade.fare.Fare;
import co.edu.poli.facade.fare.FareFactory;
import co.edu.poli.model.Reservation;
import co.edu.poli.model.Vehicle;


public class ReservationFacade {
	
	private VehicleService vehicleService = new VehicleService();
	private RentalService rentalService = new RentalService();
	
	public Reservation makeReservation(Reservation reservation) {
		System.out.println("Inside the facade...");
		
		System.out.println("Getting id from request body...");
		int vehicle_id = reservation.getIdVehicle();
		
		Vehicle vehicle = vehicleService.getVehicle(vehicle_id);
		
		FareFactory fareFactory = new FareFactory();
		Fare fare = fareFactory.evaluateFare(vehicle);
		int full_price = fare.calculateFare(reservation.getDays());
		
		System.out.println("Setting values to reservation object...");
		reservation.setPrice(full_price);
		reservation.setStatus("ON_VALIDATION");
		
		System.out.println("Publishing reservation to rental...");
		rentalService.publishToRental(reservation.getId());
				
		return reservation;
	}
}
