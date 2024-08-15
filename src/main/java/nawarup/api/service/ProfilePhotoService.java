package nawarup.api.service;



import nawarup.api.dto.ProfilePhotoDTO;
import nawarup.api.models.ProfilePhoto;

public interface ProfilePhotoService {
 
	public ProfilePhotoDTO createProfilePhoto(ProfilePhotoDTO profilePhotoDTO);
	public ProfilePhotoDTO updateProfilePhoto(ProfilePhotoDTO profilePhotoDTO);
	public ProfilePhoto getProfilePhoto(Long idProfilePhoto);
}
