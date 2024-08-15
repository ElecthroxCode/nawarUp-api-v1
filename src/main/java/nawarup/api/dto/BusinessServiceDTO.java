package nawarup.api.dto;

import java.math.BigDecimal;

import nawarup.api.models.BusinessService;



public record BusinessServiceDTO(
		Long id,
		String name,
		String description,
		BigDecimal basePrice
		) {

	public BusinessServiceDTO(BusinessService businessService) {
		this(businessService.getId(), businessService.getName(), businessService.getDescription(), businessService.getBasePrice());
	}

}
