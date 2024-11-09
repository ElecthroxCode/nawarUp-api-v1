package nawarup.api.controllers;

import nawarup.api.dto.*;
import nawarup.api.service.MediaManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/media")
public class MediaManagerController {

    private final MediaManagerService mediaService;

    @Autowired
    public MediaManagerController(MediaManagerService mediaService) {
        this.mediaService = mediaService;
    }

    @PostMapping("/{idCompany}/company-profile")
    public ResponseEntity<ProfilePhotoRespCompanyDTO> addProfilePhotoToCompany(@PathVariable Long idCompany,
                                                                               @RequestBody ProfilePhotoDTO profilePhotoDTO, UriComponentsBuilder uriComponentsBuilder) {

        ProfilePhotoRespCompanyDTO profilePhotoResponseDTO = mediaService.addProfilePhotoToCompany(idCompany, profilePhotoDTO);
        URI url = uriComponentsBuilder.path("/photo-profile/{id}")
                .buildAndExpand(profilePhotoResponseDTO.id()).toUri();
        return ResponseEntity.created(url).body(profilePhotoResponseDTO);
    }

    @PostMapping("/{idCompany}/company-background")
    public ResponseEntity<BackgroundPhotoRespCompanyDTO> addBackgroundPhotoToCompany(@PathVariable Long idCompany,
                                                                                     @RequestBody BackgroundPhotoDTO backgroundPhotoDTO, UriComponentsBuilder uriComponentsBuilder) {

        BackgroundPhotoRespCompanyDTO backgroundPhotoRespCompanyDTO = mediaService
                .addBackgoudPhotoToCompany(idCompany, backgroundPhotoDTO);
        URI url = uriComponentsBuilder.path("/photo-background/{id}").
                buildAndExpand(backgroundPhotoRespCompanyDTO.id()).toUri();
        return ResponseEntity.created(url).body(backgroundPhotoRespCompanyDTO);
    }

    /**/

    @PostMapping("/{idCompany}/company-profile-replace")
    public ResponseEntity<ProfilePhotoResponseDTO> replaceProfilePhotoToCompany(@PathVariable Long idCompany,
                                                                                @RequestBody ProfilePhotoDTO profilePhotoDTO, UriComponentsBuilder uriComponentsBuilder) {

        ProfilePhotoResponseDTO profilePhotoResponseDTO = mediaService.replaceProfilePhotoToCompany(idCompany, profilePhotoDTO);
        URI url = uriComponentsBuilder.path("/photo-profile/{id}")
                .buildAndExpand(profilePhotoResponseDTO.id()).toUri();
        return ResponseEntity.created(url).body(profilePhotoResponseDTO);
    }

    @PostMapping("/{idCompany}/company-background-replace")
    public ResponseEntity<BackgroundPhotoResponseDTO> replaceBackgroundPhotoToCompany(@PathVariable Long idCompany,
                                                                                      @RequestBody BackgroundPhotoDTO backgroundPhotoDTO, UriComponentsBuilder uriComponentsBuilder) {

        BackgroundPhotoResponseDTO backgroundPhotoResponseDTO = mediaService.replaceBackgroundPhotoToCompany(idCompany, backgroundPhotoDTO);
        URI url = uriComponentsBuilder.path("/photo-background/{id}")
                .buildAndExpand(backgroundPhotoResponseDTO.id()).toUri();
        return ResponseEntity.created(url).body(backgroundPhotoResponseDTO);
    }

    @PostMapping("/{idCustomer}/customer-profile-replace")
    public ResponseEntity<ProfilePhotoResponseDTO> replaceProfilePhotoToCustomer(@PathVariable Long idCustomer,
                                                                                 @RequestBody ProfilePhotoDTO profilePhotoDTO, UriComponentsBuilder uriComponentsBuilder) {

        ProfilePhotoResponseDTO profilePhotoResponseDTO = mediaService.replaceProfilePhotoToCustomer(idCustomer, profilePhotoDTO);
        URI url = uriComponentsBuilder.path("/photo-profile/{id}")
                .buildAndExpand(profilePhotoResponseDTO.id()).toUri();
        return ResponseEntity.created(url).body(profilePhotoResponseDTO);
    }

    @PostMapping("/{idCustomer}/customer-background-replace")
    public ResponseEntity<BackgroundPhotoResponseDTO> replaceBackgroundPhotoToCustomer(@PathVariable Long idCustomer,
                                                                                       @RequestBody BackgroundPhotoDTO backgroundPhotoDTO, UriComponentsBuilder uriComponentsBuilder) {

        BackgroundPhotoResponseDTO backgroundPhotoResponseDTO = mediaService.replaceBackgroundPhotoToCustomer(idCustomer, backgroundPhotoDTO);
        URI url = uriComponentsBuilder.path("/photo-background/{id}")
                .buildAndExpand(backgroundPhotoResponseDTO.id()).toUri();
        return ResponseEntity.created(url).body(backgroundPhotoResponseDTO);
    }

    @PostMapping("/{idCustomer}/customer-profile")
    public ResponseEntity<ProfilePhotoRespCustomerDTO> addProfilePhotoToCustomer(@PathVariable Long idCustomer,
                                                                                 @RequestBody ProfilePhotoDTO profilePhotoDTO, UriComponentsBuilder uriComponentsBuilder) {

        ProfilePhotoRespCustomerDTO profilePhotoRespCustomerDTO = mediaService.addProfilePhotoToCustomer(idCustomer, profilePhotoDTO);
        URI url = uriComponentsBuilder.path("/photo-profile/{id}")
                .buildAndExpand(profilePhotoRespCustomerDTO.id()).toUri();
        return ResponseEntity.created(url).body(profilePhotoRespCustomerDTO);
    }

    @PostMapping("/{idCustomer}/customer-background")
    public ResponseEntity<BackgroundPhotoRespCustomerDTO> addBackgroundPhotoToCustomer(@PathVariable Long idCustomer, @RequestBody BackgroundPhotoDTO backgroundPhotoDTO,
                                                                                       UriComponentsBuilder uriCompoenentsBuilder) {

        BackgroundPhotoRespCustomerDTO backgroundPhotoRespCustomerDTO = mediaService.addBackgoudPhotoToCustomer(idCustomer, backgroundPhotoDTO);
        URI url = uriCompoenentsBuilder.path("/photo-background/{id}")
                .buildAndExpand(backgroundPhotoRespCustomerDTO.id()).toUri();
        return ResponseEntity.created(url).body(backgroundPhotoRespCustomerDTO);
    }

    @PostMapping("/{idBusinessService}/services")
    public ResponseEntity<BusinessServiceMediaResponseDTO> replaceBusinessServiceMediaToBusinessService(@PathVariable Long idBusinessService,
                                                                                                        @RequestBody BusinessServiceMediaDTO businessServiceMediaDTO, UriComponentsBuilder uriComponentsBuilder) {

        BusinessServiceMediaResponseDTO businessServiceMediaResponseDTO =
                mediaService.replaceBusinessServiceMediaToBusinessService(idBusinessService, businessServiceMediaDTO);
        URI url = uriComponentsBuilder.path("/media-service/{id}").buildAndExpand(businessServiceMediaResponseDTO.id()).toUri();
        return ResponseEntity.created(url).body(businessServiceMediaResponseDTO);
    }

    @DeleteMapping("/remove-service/{idBusinessServiceMedia}")
    public ResponseEntity<Void> deleteBusinessServiceMediaToBusinessService(@PathVariable Long idBusinessServiceMedia) {
        mediaService.deleteBusinessServiceMediaToBusinessService(idBusinessServiceMedia);
        return ResponseEntity.noContent().build();
    }


}
