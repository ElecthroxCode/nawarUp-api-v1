package nawarup.api.dto;

import nawarup.api.models.ProfilePhoto;

public record ProfilePhotoDTO(
        Long id,
        String url
) {
    public ProfilePhotoDTO(ProfilePhoto profilePhoto) {
        this(profilePhoto.getId(), profilePhoto.getUrl());
    }

}
