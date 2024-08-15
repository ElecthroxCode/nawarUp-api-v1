package nawarup.api.dto;

import nawarup.api.models.BackgroundPhoto;

public record BackgroundPhotoDTO(
		Long id,
		String url
		) {

	public BackgroundPhotoDTO(BackgroundPhoto backgroundPhoto) {
		this(backgroundPhoto.getId(), backgroundPhoto.getUrl());
	}



}
