package nawarup.api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;



public record ReservationDTO(
		Long id,
		int personServed,
		String details,
		LocalDate date
		) {

}
