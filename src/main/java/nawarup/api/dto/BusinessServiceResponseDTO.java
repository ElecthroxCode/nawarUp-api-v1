package nawarup.api.dto;

import java.math.BigDecimal;

import nawarup.api.models.BusinessService;

public record BusinessServiceResponseDTO(
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
