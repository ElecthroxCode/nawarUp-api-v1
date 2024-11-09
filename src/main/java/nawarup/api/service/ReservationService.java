package nawarup.api.service;

import nawarup.api.dto.ReservationDTO;
import nawarup.api.dto.ReservationResponseDTO;

public interface ReservationService {
    ReservationResponseDTO addReservationToCustomer(Long idCustomer, Long idBusinessService,
                                                    ReservationDTO reservationDTO, Long idMBusinessServiceMedia);

    void deleteReservationToCustomer(Long idReservaion);

}
