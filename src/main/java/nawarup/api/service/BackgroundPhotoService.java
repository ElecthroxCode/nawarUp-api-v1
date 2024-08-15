package nawarup.api.service;

import nawarup.api.dto.BackgroundPhotoDTO;
import nawarup.api.models.BackgroundPhoto;

public interface BackgroundPhotoService {
	public BackgroundPhotoDTO createBackgroundPhoto(BackgroundPhotoDTO backgroundPhotoDTO);
	public BackgroundPhotoDTO updateBackgroundePhoto(BackgroundPhotoDTO backgroundPhotoDTO );
	public BackgroundPhoto getBAckgroundePhoto(Long idBackgroundPhoto);
}
