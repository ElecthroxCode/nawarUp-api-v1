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
import nawarup.api.dto.ProfilePhotoDTO;

@Entity
@Table(name = "profile_photos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class ProfilePhoto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_profile_photo")
	private Long id;
	private String url;
	
	public ProfilePhoto(ProfilePhotoDTO profilePhotoDTO) {
		this.id = profilePhotoDTO.id();
		this.url = profilePhotoDTO.url();
	}

	public void updateProfilePhoto(ProfilePhotoDTO profilePhotoDTO) {
		if(profilePhotoDTO.url() != null) {
			this.url = profilePhotoDTO.url();
		}
		
	}

}
