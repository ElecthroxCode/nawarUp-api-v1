package nawarup.api.dto;

import nawarup.api.models.BusinessService;

import java.math.BigDecimal;

public record  BusinessServiceResponseDTO(
        Long id,
        String name,
        String description,
        BigDecimal basePrice
) {

    public BusinessServiceResponseDTO(BusinessService businessService) {
        this(businessService.getId(), businessService.getName(), businessService.getDescription(),
                businessService.getBasePrice());
    }


}
