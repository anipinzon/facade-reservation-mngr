package co.edu.poli.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.poli.model.Reservation;

public interface ReservationRepository extends MongoRepository<Reservation, String> {

}
