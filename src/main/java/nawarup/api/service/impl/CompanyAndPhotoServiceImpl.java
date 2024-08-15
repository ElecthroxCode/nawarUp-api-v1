package nawarup.api.service.impl;

import nawarup.api.models.Company;
import nawarup.api.models.ProfilePhoto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import nawarup.api.dto.BackgroundPhotoDTO;
import nawarup.api.dto.ProfilePhotoDTO;
import nawarup.api.models.BackgroundPhoto;
import nawarup.api.service.CompanyAndPhotoService;

@Service
public class CompanyAndPhotoServiceImpl implements CompanyAndPhotoService{
	@Autowired
	private CompanyServiceImpl companyServiceImpl;
	
	
	@Transactional
	@Override
	public ProfilePhotoDTO addProfilePhotoToCompany(Long idCompany, ProfilePhotoDTO profilePhotoDTO) {
		Company company = companyServiceImpl.getCompany(idCompany);
		ProfilePhoto profilePhoto = new ProfilePhoto(profilePhotoDTO);
		if(company.getUrlProfilePhoto() != null) {
			company.deleteProfilePhoto();
		}
		company.addProfilePhoto(profilePhoto);
		return new ProfilePhotoDTO(company.getUrlProfilePhoto());
	}
	
	
	@Transactional
	@Override
	public BackgroundPhotoDTO addBackgroundPhotoToCompany(Long idCompany, BackgroundPhotoDTO backgroundPhotoDTO) {
		
		Company company = companyServiceImpl.getCompany(idCompany);
		BackgroundPhoto backgroundPhoto = new BackgroundPhoto(backgroundPhotoDTO);
		company.addBackgroundPhoto(backgroundPhoto);
		return new BackgroundPhotoDTO(backgroundPhoto);
	}
		


}
