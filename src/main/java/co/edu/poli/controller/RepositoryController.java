package co.edu.poli.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
		reservationRepository.save(reservationFacade.makeReservation(newReservation));		
		return newReservation;		
	}
	
	@GetMapping("/reservation/{id}")
	public Reservation postReservation(@PathVariable String id) {		
		return reservationRepository.findById(id).get();		
	}

}
