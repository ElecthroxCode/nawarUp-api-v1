package nawarup.api.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import nawarup.api.dto.BackgroundPhotoDTO;
import nawarup.api.dto.ProfilePhotoDTO;
import nawarup.api.service.impl.CompanyAndPhotoServiceImpl;

@RestController
@RequestMapping("/companies/photos")
public class CompanyAndPhotoController {
	@Autowired
	CompanyAndPhotoServiceImpl companyAndPhotoServiceImpl;
	
	@PostMapping("/profile/{idCompany}")
	public ResponseEntity<ProfilePhotoDTO> addProfilePhotoToCompany(@PathVariable Long idCompany, @RequestBody ProfilePhotoDTO profilePhotoDTO,
			UriComponentsBuilder uriComponentsBuilder){
		ProfilePhotoDTO newProfilePhotoDTO = companyAndPhotoServiceImpl.addProfilePhotoToCompany(idCompany, profilePhotoDTO);
		URI url = uriComponentsBuilder.path("/companies/photos/pf/{id}").buildAndExpand(newProfilePhotoDTO.id()).toUri();
		return ResponseEntity.created(url).body(newProfilePhotoDTO);
	}
	
	@PostMapping("/background/{idCompany}")
	public ResponseEntity<BackgroundPhotoDTO> addBackgroundPhotoToCompany(@PathVariable Long idCompany, @RequestBody BackgroundPhotoDTO backgroundPhotoDTO, 
			UriComponentsBuilder uriComponentsBuilder){
		BackgroundPhotoDTO newbackgroundPhotoDTO = companyAndPhotoServiceImpl.addBackgroundPhotoToCompany(idCompany, backgroundPhotoDTO);
		URI url = uriComponentsBuilder.path("/companies/photos/bg/{id}").buildAndExpand(newbackgroundPhotoDTO.id()).toUri();
		return ResponseEntity.created(url).body(newbackgroundPhotoDTO);
	}

	
}
