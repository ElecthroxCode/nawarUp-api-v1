package nawarup.api.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import nawarup.api.dto.BusinessServiceDTO;
import nawarup.api.dto.BusinessServiceResponseDTO;
import nawarup.api.dto.BusinessServiceUpdateDTO;
import nawarup.api.dto.CompanyDTO;
import nawarup.api.dto.CompanyResponseDTO;
import nawarup.api.dto.CompanyUpdateDTO;
import nawarup.api.service.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController {
	
	private final CompanyService companyService;
	
	@Autowired
	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}
	
	@PostMapping
	public ResponseEntity<CompanyResponseDTO> createCompany(@RequestBody CompanyDTO companyDTO, UriComponentsBuilder uriComponentsBuilder){
		
		CompanyResponseDTO companyResponseDTO = companyService.createCompany(companyDTO);
		URI url = uriComponentsBuilder.path("/companies/{id}").buildAndExpand(companyResponseDTO.id()).toUri();
		return ResponseEntity.created(url).body(companyResponseDTO);
	}

	@PutMapping
	public ResponseEntity<CompanyUpdateDTO> updateCompany(@RequestBody CompanyUpdateDTO companyUpdateDTO){
		
		return ResponseEntity.ok(companyService.updateCompany(companyUpdateDTO));
	}
	
	@PostMapping("/{idCompany}/services")
	public ResponseEntity<BusinessServiceResponseDTO> addBusinessServiceToCompany(@PathVariable Long idCompany, @RequestBody BusinessServiceDTO businessServiceDTO, 
			UriComponentsBuilder uriComponentsBuilder){
		
		BusinessServiceResponseDTO businessServiceResponseDTO = companyService.addBusinessServiceToCompany(idCompany, businessServiceDTO);
		URI url = uriComponentsBuilder.path("/businessService-added/{id}")
				.buildAndExpand(businessServiceResponseDTO.id()).toUri();
		return ResponseEntity.created(url).body(businessServiceResponseDTO);
	}
	
	@PutMapping("/service")
	public ResponseEntity<BusinessServiceUpdateDTO> updateBusinessServiceToCompany(@RequestBody BusinessServiceUpdateDTO businessServiceUpdateDTO){
		
		return ResponseEntity.ok(companyService.updateBusinessServiceToCompany(businessServiceUpdateDTO));
	}
	
	
}
