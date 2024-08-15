package nawarup.api.service;

import nawarup.api.dto.BackgroundPhotoDTO;
import nawarup.api.dto.ProfilePhotoDTO;

public interface CompanyAndPhotoService {

	public ProfilePhotoDTO addProfilePhotoToCompany(Long idCompany, ProfilePhotoDTO profilePhotoDTO);
	public BackgroundPhotoDTO addBackgroundPhotoToCompany(Long idCompany, BackgroundPhotoDTO backgroundPhotoDTO);
	
}
