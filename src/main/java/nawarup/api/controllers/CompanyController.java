package nawarup.api.controllers;

import nawarup.api.dto.*;
import nawarup.api.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/companies")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<Page<CompanyListDTO>> getAllCompanies(@PageableDefault(size = 2) Pageable pageable){
        return ResponseEntity.ok(companyService.getAllCompany(pageable));
    }
    @GetMapping("/{idCompany}")
    public ResponseEntity<CompanyResponseDTO> getCompany(@PathVariable Long idCompany){
        CompanyResponseDTO companyResponseDTO = new CompanyResponseDTO(companyService.getCompany(idCompany));
        return ResponseEntity.ok(companyResponseDTO);
    }
@GetMapping("/user/{idUser}")
    public ResponseEntity<CompanyResponseDTO> getCompanyByIdUser(@PathVariable Long idUser){
        CompanyResponseDTO companyResponseDTO =  new CompanyResponseDTO(companyService.getCompanyByIdUser(idUser));
        return ResponseEntity.ok(companyResponseDTO);
    }

    @PostMapping
    public ResponseEntity<CompanyResponseDTO> createCompany(@RequestBody CompanyDTO companyDTO, UriComponentsBuilder uriComponentsBuilder) {

        CompanyResponseDTO companyResponseDTO = companyService.createCompany(companyDTO);
        URI url = uriComponentsBuilder.path("/companies/{id}").buildAndExpand(companyResponseDTO.id()).toUri();
        return ResponseEntity.created(url).body(companyResponseDTO);
    }

    @PutMapping
    public ResponseEntity<CompanyUpdateDTO> updateCompany(@RequestBody CompanyUpdateDTO companyUpdateDTO) {

        return ResponseEntity.ok(companyService.updateCompany(companyUpdateDTO));
    }

    @PostMapping("/{idCompany}/services")
    public ResponseEntity<BusinessServiceResponseDTO> addBusinessServiceToCompany(@PathVariable Long idCompany, @RequestBody BusinessServiceDTO businessServiceDTO,
                                                                                  UriComponentsBuilder uriComponentsBuilder) {

        BusinessServiceResponseDTO businessServiceResponseDTO = companyService.addBusinessServiceToCompany(idCompany, businessServiceDTO);
        URI url = uriComponentsBuilder.path("/businessService-added/{id}")
                .buildAndExpand(businessServiceResponseDTO.id()).toUri();
        return ResponseEntity.created(url).body(businessServiceResponseDTO);
    }

    @PutMapping("/service")
    public ResponseEntity<BusinessServiceUpdateDTO> updateBusinessServiceToCompany(@RequestBody BusinessServiceUpdateDTO businessServiceUpdateDTO) {

        return ResponseEntity.ok(companyService.updateBusinessServiceToCompany(businessServiceUpdateDTO));
    }


}
