package nawarup.api.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import nawarup.api.dto.ReservationDTO;
import nawarup.api.dto.ReservationResponseDTO;
import nawarup.api.service.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
	private final ReservationService reservationService;
	@Autowired
	public ReservationController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	@PostMapping("/{idCustomer}/{idBusinessService}/{idBusinessServiceMedia}")
	public ResponseEntity<ReservationResponseDTO> addReservation(@PathVariable Long idCustomer,
			@PathVariable Long idBusinessService, @RequestBody ReservationDTO reservationDTO,
			@PathVariable Long idBusinessServiceMedia, UriComponentsBuilder uriComponentsBuilder){
		
		ReservationResponseDTO reservationResponseDTO = reservationService.addReservationToCustomer(idCustomer, idBusinessService, reservationDTO, idBusinessServiceMedia);
		URI url = uriComponentsBuilder.path("/{id}").buildAndExpand(reservationResponseDTO.id()).toUri() ;
		return ResponseEntity.created(url).body(reservationResponseDTO);
	}
	
	@DeleteMapping("/{idReservation}")
	public ResponseEntity<Void> deleteReservation(@PathVariable Long idReservation) {
		reservationService.deleteReservationToCustomer(idReservation);
		return ResponseEntity.noContent().build();
	}
}
