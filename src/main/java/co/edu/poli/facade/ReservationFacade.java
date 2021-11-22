package co.edu.poli.facade;

import co.edu.poli.facade.fare.Fare;
import co.edu.poli.facade.fare.FareFactory;
import co.edu.poli.model.Reservation;
import co.edu.poli.model.Vehicle;


public class ReservationFacade {
	
	private VehicleService vehicleService;
	private RentalService rentalService;
	
	public Reservation makeReservation(Reservation reservation) {
		Long vehicle_id = reservation.getIdVehicle();
		Vehicle vehicle = vehicleService.getVehicle(vehicle_id);
		
		FareFactory fareFactory = new FareFactory();
		Fare fare = fareFactory.evaluateFare(vehicle);
		int full_price = fare.calculateFare(reservation.getDays());
		
		reservation.setPrice(full_price);
		reservation.setStatus("ON_VALIDATION");
		
		rentalService.publishToRental(reservation.getId());
				
		return reservation;
	}
}
