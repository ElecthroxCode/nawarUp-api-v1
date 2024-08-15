package nawarup.api.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.transaction.Transactional;
import nawarup.api.dto.CompanyDTO;
import nawarup.api.dto.CompanyUpdateDTO;
import nawarup.api.service.impl.CompanyServiceImpl;

@RestController
@RequestMapping("/companies")
public class CompanyController {
	
	@Autowired
	CompanyServiceImpl companyServiceImpl;
	
	@PostMapping
	public ResponseEntity<CompanyDTO> createCompany(@RequestBody CompanyDTO companyDTO, UriComponentsBuilder uriComponentsBuilder){
		CompanyDTO newCompanyDTO = companyServiceImpl.createCompany(companyDTO);
		
		URI url = uriComponentsBuilder.path("/companies/{id}").buildAndExpand(newCompanyDTO.id()).toUri();
		
		return ResponseEntity.created(url).body(newCompanyDTO);
	}

	
	@PutMapping
	@Transactional
	public ResponseEntity<CompanyUpdateDTO> updateCompany(@RequestBody CompanyUpdateDTO companyUpdateDTO){
		
		return ResponseEntity.ok(companyServiceImpl.updateCompany(companyUpdateDTO));
	}
	
}
