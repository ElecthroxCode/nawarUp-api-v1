package nawarup.api.dto;

import nawarup.api.models.ProfilePhoto;

public record ProfilePhotoRespCompanyDTO(
        Long id,
        String url,
        CompanyResponseDTO company
) {
    public ProfilePhotoRespCompanyDTO(ProfilePhoto profilePhoto) {
        this(profilePhoto.getId(), profilePhoto.getUrl(),
                new CompanyResponseDTO(profilePhoto.getCompany()));
    }
}
