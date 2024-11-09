package nawarup.api.dto;

import nawarup.api.models.BackgroundPhoto;

public record BackgroundPhotoRespCustomerDTO(
        Long id,
        String url,
        CustomerResponseDTO customer

) {

    public BackgroundPhotoRespCustomerDTO(BackgroundPhoto backgroundPhoto) {
        this(backgroundPhoto.getId(), backgroundPhoto.getUrl(), new CustomerResponseDTO(backgroundPhoto.getCustomer()));
    }

}
