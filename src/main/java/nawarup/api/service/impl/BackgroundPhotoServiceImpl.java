package nawarup.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import nawarup.api.dto.BackgroundPhotoDTO;
import nawarup.api.models.BackgroundPhoto;
import nawarup.api.repository.BackgroundPhotoRepository;
import nawarup.api.service.BackgroundPhotoService;

public class BackgroundPhotoServiceImpl implements BackgroundPhotoService{
	@Autowired
	private BackgroundPhotoRepository backgroundPhotoRepository;

	@Override
	public BackgroundPhotoDTO createBackgroundPhoto(BackgroundPhotoDTO backgroundPhotoDTO) {
		
		return new BackgroundPhotoDTO(backgroundPhotoRepository.save(new BackgroundPhoto(backgroundPhotoDTO)));
	}

	@Override
	public BackgroundPhotoDTO updateBackgroundePhoto(BackgroundPhotoDTO backgroundPhotoDTO) {
		BackgroundPhoto backgroundPhoto = backgroundPhotoRepository.getReferenceById(backgroundPhotoDTO.id());
		backgroundPhoto.updateBackgroundPhoto(backgroundPhotoDTO);
		return new BackgroundPhotoDTO(backgroundPhoto);
	}

	@Override
	public BackgroundPhoto getBAckgroundePhoto(Long idBackgroundPhoto) {
		
		return backgroundPhotoRepository.getReferenceById(idBackgroundPhoto);
	}

}
