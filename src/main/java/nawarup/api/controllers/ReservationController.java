package nawarup.api.controllers;

import nawarup.api.dto.ReservationDTO;
import nawarup.api.dto.ReservationResponseDTO;
import nawarup.api.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

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
                                                                 @PathVariable Long idBusinessServiceMedia, UriComponentsBuilder uriComponentsBuilder) {

        ReservationResponseDTO reservationResponseDTO = reservationService.addReservationToCustomer(idCustomer, idBusinessService, reservationDTO, idBusinessServiceMedia);
        URI url = uriComponentsBuilder.path("/{id}").buildAndExpand(reservationResponseDTO.id()).toUri();
        return ResponseEntity.created(url).body(reservationResponseDTO);
    }

    @DeleteMapping("/{idReservation}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long idReservation) {
        reservationService.deleteReservationToCustomer(idReservation);
        return ResponseEntity.noContent().build();
    }
}
