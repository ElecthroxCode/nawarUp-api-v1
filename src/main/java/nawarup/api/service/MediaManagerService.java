package nawarup.api.service;

import nawarup.api.dto.*;

public interface MediaManagerService {
    ProfilePhotoRespCompanyDTO addProfilePhotoToCompany(Long idCompany, ProfilePhotoDTO profilePhotoDTO);

    BackgroundPhotoRespCustomerDTO addBackgoudPhotoToCustomer(Long idCustomer, BackgroundPhotoDTO backgroundPhotoDTO);

    ProfilePhotoRespCustomerDTO addProfilePhotoToCustomer(Long idCustomer, ProfilePhotoDTO profilePhotoDTO);

    BackgroundPhotoRespCompanyDTO addBackgoudPhotoToCompany(Long idCompany, BackgroundPhotoDTO backgroundPhotoDTO);

    void deleteProfilePhoto(Long idPhoto);

    void deleteBackgroundPhoto(Long idPhoto);

    ProfilePhotoResponseDTO replaceProfilePhotoToCustomer(Long idCustomer, ProfilePhotoDTO profilePhotoDTO);

    BackgroundPhotoResponseDTO replaceBackgroundPhotoToCustomer(Long idCustomer, BackgroundPhotoDTO backgroundPhotoDTO);

    ProfilePhotoResponseDTO replaceProfilePhotoToCompany(Long idCompany, ProfilePhotoDTO profilePhotoDTO);

    BackgroundPhotoResponseDTO replaceBackgroundPhotoToCompany(Long idCompany, BackgroundPhotoDTO backgroundPhotoDTO);

    BusinessServiceMediaResponseDTO replaceBusinessServiceMediaToBusinessService(Long idBusinessService, BusinessServiceMediaDTO businessServiceMediaDTO);

    void deleteBusinessServiceMediaToBusinessService(Long idBusinessServiceMedia);
}
	