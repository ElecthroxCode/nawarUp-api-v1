package nawarup.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nawarup.api.dto.BackgroundPhotoDTO;

@Entity
@Table(name = "background_photos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class BackgroundPhoto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_background_photo")
	private Long id;
	private String url;
	
	public BackgroundPhoto(BackgroundPhotoDTO backgroundPhotoDTO) {
		this.id = backgroundPhotoDTO.id();
		this.url = backgroundPhotoDTO.url();
	}

	public void updateBackgroundPhoto(BackgroundPhotoDTO backgroundPhotoDTO) {
		if(backgroundPhotoDTO.url() != null ) {
			this.url = backgroundPhotoDTO.url();
		}
		
	}

}

