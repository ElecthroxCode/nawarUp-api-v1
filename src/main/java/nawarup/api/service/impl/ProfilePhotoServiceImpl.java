package nawarup.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nawarup.api.dto.ProfilePhotoDTO;
import nawarup.api.models.ProfilePhoto;
import nawarup.api.repository.ProfilePhotoRepository;
import nawarup.api.service.ProfilePhotoService;

@Service
public class ProfilePhotoServiceImpl implements ProfilePhotoService{
	@Autowired
	private ProfilePhotoRepository profilePhotoRepository;
	
	@Override
	public ProfilePhotoDTO createProfilePhoto(ProfilePhotoDTO profilePhotoDTO) {
		
		return new ProfilePhotoDTO(profilePhotoRepository.save(new ProfilePhoto(profilePhotoDTO)));
	}

	@Override
	public ProfilePhotoDTO updateProfilePhoto(ProfilePhotoDTO profilePhotoDTO) {
		ProfilePhoto profilePhoto = getProfilePhoto(profilePhotoDTO.id());
		profilePhoto.updateProfilePhoto(profilePhotoDTO);
		return null;
	}

	@Override
	public ProfilePhoto getProfilePhoto(Long idProfilePhoto) {
		
		return profilePhotoRepository.getReferenceById(idProfilePhoto);
	}

}
