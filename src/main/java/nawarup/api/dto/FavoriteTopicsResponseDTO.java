package nawarup.api.dto;

import nawarup.api.models.FavoriteTopics;

public record FavoriteTopicsResponseDTO(Long id, String name) {
	public FavoriteTopicsResponseDTO(FavoriteTopics favoriteTopics) {
		this(favoriteTopics.getId(), favoriteTopics.getName());
	}
}
