package nawarup.api.dto;

import nawarup.api.models.FavoriteTopics;

public record FavoriteTopicsDTO(
        Long id,
        String name
) {
    public FavoriteTopicsDTO(FavoriteTopics favoriteTopics) {
        this(favoriteTopics.getId(), favoriteTopics.getName());
    }
}
