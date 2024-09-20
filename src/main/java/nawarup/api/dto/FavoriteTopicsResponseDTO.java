package nawarup.api.dto;

import nawarup.api.models.FavoriteTopics;

public record FavoriteTopicsResponseDTO(Long id, String name, CustomerResponseDTO customer) {
	
	public FavoriteTopicsResponseDTO(FavoriteTopics favoriteTopics) {
		this(favoriteTopics.getId(), favoriteTopics.getName(),
				new CustomerResponseDTO(favoriteTopics.getCustomer()));
	}
}
