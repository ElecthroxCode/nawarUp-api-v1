package nawarup.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nawarup.api.models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}
