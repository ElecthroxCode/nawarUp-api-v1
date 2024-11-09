package nawarup.api.dto;

import nawarup.api.models.BackgroundPhoto;

public record BackgroundPhotoRespCompanyDTO(
        Long id,
        String url,
        CompanyResponseDTO company

) {

    public BackgroundPhotoRespCompanyDTO(BackgroundPhoto backgroundPhoto) {
        this(backgroundPhoto.getId(), backgroundPhoto.getUrl(), new CompanyResponseDTO(backgroundPhoto.getCompany()));
    }

}
