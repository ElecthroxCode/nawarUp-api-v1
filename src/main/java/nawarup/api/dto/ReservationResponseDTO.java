package nawarup.api.dto;

import nawarup.api.models.Reservation;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ReservationResponseDTO(
        Long id,
        int personServed,
        String details,
        LocalDate date,
        BigDecimal totalPyment,
        String service,
        String customer

) {
    public ReservationResponseDTO(Reservation reservation) {
        this(reservation.getId(), reservation.getPersonServed(), reservation.getDetails(),
                reservation.getDate(), reservation.getTotalPayment(), reservation.getBusinessService().getName(),
                reservation.getCustomer().getName());
    }

}
