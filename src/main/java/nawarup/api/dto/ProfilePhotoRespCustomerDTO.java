package nawarup.api.dto;

import nawarup.api.models.ProfilePhoto;

public record ProfilePhotoRespCustomerDTO(
        Long id,
        String url,
        CustomerResponseDTO customer
) {
    public ProfilePhotoRespCustomerDTO(ProfilePhoto profilePhoto) {
        this(profilePhoto.getId(), profilePhoto.getUrl(),
                new CustomerResponseDTO(profilePhoto.getCustomer()));
    }

}
