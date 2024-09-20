package nawarup.api.service;

import nawarup.api.dto.BackgroundPhotoDTO;
import nawarup.api.dto.BackgroundPhotoRespCompanyDTO;
import nawarup.api.dto.BackgroundPhotoRespCustomerDTO;
import nawarup.api.dto.BackgroundPhotoResponseDTO;
import nawarup.api.dto.BusinessServiceMediaDTO;
import nawarup.api.dto.BusinessServiceMediaResponseDTO;
import nawarup.api.dto.ProfilePhotoDTO;
import nawarup.api.dto.ProfilePhotoRespCompanyDTO;
import nawarup.api.dto.ProfilePhotoRespCustomerDTO;
import nawarup.api.dto.ProfilePhotoResponseDTO;

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
	