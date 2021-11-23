package co.edu.poli.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.facade.ReservationFacade;
import co.edu.poli.model.Reservation;
import co.edu.poli.repository.ReservationRepository;

@Transactional
@RestController
@RequestMapping	("/api/v1")
public class RepositoryController {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	private ReservationFacade reservationFacade;
	
	@PostMapping("/reservation")
	public Reservation postReservation(@RequestBody Reservation newReservation) {
		System.out.println("Inside the controller...");
		System.out.println(newReservation.toString());
		Reservation _reservation = reservationFacade.makeReservation(newReservation);	
		System.out.println(_reservation.toString());
		reservationRepository.save(_reservation);		
		return newReservation;
				
	}
	
	@GetMapping("/reservation/{id}")
	public Reservation postReservation(@PathVariable String id) {
		
		try {
			return reservationRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			System.out.println("User not found");
			return null;
		} catch (Exception e) {
			return null;
		}
				
	}
	
	@PutMapping("/reservation/{id}")
	public Reservation updateReservationStatus(@RequestBody Reservation reservation) {
		try {
			Reservation _current = reservationRepository.findById(reservation.getId()).get();
			_current.setUsername(reservation.getUsername());
			_current.setStatus(reservation.getStatus());
			_current.setPrice(reservation.getPrice());
			reservationRepository.save(_current);		
			return _current;
		} catch (NoSuchElementException e) {
			System.out.println("User not found");
			return null;
		} catch (Exception e) {
			return null;
		}
		
		
	}

}
