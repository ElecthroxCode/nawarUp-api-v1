package nawarup.api.dto;

import java.math.BigDecimal;

public record BusinessServiceUpdateDTO(
        Long id,
        String name,
        String description,
        BigDecimal basePrice) {

}
