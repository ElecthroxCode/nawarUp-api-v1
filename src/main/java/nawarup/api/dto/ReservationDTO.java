package nawarup.api.dto;

import java.time.LocalDate;



public record ReservationDTO(
		Long id,
		int personServed,
		String details,
		LocalDate date
		) {

}
