package nawarup.api.dto;

import nawarup.api.models.BusinessServiceMedia;

public record BusinessServiceMediaResponseDTO(
		Long id,
		String url,
		String designType,
		BusinessServiceResponseDTO service
		) {
	public BusinessServiceMediaResponseDTO(BusinessServiceMedia businessServiceMedia) {
		this(businessServiceMedia.getId(),businessServiceMedia.getUrl(),
				businessServiceMedia.getDesignType(), new BusinessServiceResponseDTO(businessServiceMedia.getBusinessService()));
	}
}
