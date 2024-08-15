package nawarup.api.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import nawarup.api.dto.BusinessServiceDTO;
import nawarup.api.service.impl.CompanyAndBusinessServiceServiceImpl;

@RestController
@RequestMapping("/companies")
public class CompanyAndBusinessServiceController {
	@Autowired
	CompanyAndBusinessServiceServiceImpl companyAndBusinessServiceServiceImpl;
	
	@PostMapping("/{idCompany}/service")
	public ResponseEntity<BusinessServiceDTO> addBusinessServiceTuCompany(@PathVariable Long idCompany,
			@RequestBody BusinessServiceDTO businessServiceDTO,
			UriComponentsBuilder uriComponentsBilder) {
		BusinessServiceDTO newBusinessServiceDTO = companyAndBusinessServiceServiceImpl.addBusinessServiceToCompany(
				idCompany, businessServiceDTO);
		
		URI url = uriComponentsBilder.path("/added/service/{id}").buildAndExpand(newBusinessServiceDTO.id()).toUri();
		return ResponseEntity.created(url).body(newBusinessServiceDTO);
		
	}
	
	@PutMapping("/update/service")
	public ResponseEntity<BusinessServiceDTO> updateBusinessService(@RequestBody BusinessServiceDTO businessServiceDTO){
		
		return ResponseEntity.ok(companyAndBusinessServiceServiceImpl.updateBusinessService(businessServiceDTO));
	}
	
	@DeleteMapping("service/delete/{idBusinessService}")
	public ResponseEntity deleteBusinessService(@PathVariable Long idBusinessService) {
		companyAndBusinessServiceServiceImpl.deleteBusinessService(idBusinessService);
		return ResponseEntity.noContent().build();
	}
	
}
