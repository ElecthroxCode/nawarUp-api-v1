package nawarup.api.dto;

import nawarup.api.models.BusinessService;

import java.math.BigDecimal;


public record BusinessServiceDTO(
        Long id,
        String name,
        String description,
        BigDecimal basePrice
) {

    public BusinessServiceDTO(BusinessService businessService) {
        this(businessService.getId(), businessService.getName(), businessService.getDescription(),
                businessService.getBasePrice());
    }

}
