package nawarup.api.service.impl;

import jakarta.persistence.EntityNotFoundException;
import nawarup.api.dto.*;
import nawarup.api.models.*;
import nawarup.api.repository.*;
import nawarup.api.service.MediaManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MediaManagerServiceImpl implements MediaManagerService {

    private final ProfilePhotoRepository profilePhotoRepository;
    private final BackgroundPhotoRepository backgroundPhotoRepository;
    private final CompanyRepository companyRepository;
    private final CustomerRepository customerRepository;
    private final BusinessServiceRepository businessServiceRepository;
    private final BusinessServiceMediaRepository businessServiceMediaRepository;
    private ProfilePhoto profilePhoto;
    private BackgroundPhoto backgroundPhoto;

    @Autowired
    public MediaManagerServiceImpl(ProfilePhotoRepository profilePhotoRepository,
                                   BackgroundPhotoRepository backgroundPhotoRepository, CompanyRepository companyRepository,
                                   CustomerRepository customerRepository, BusinessServiceMediaRepository businessServiceMediaRepository,
                                   BusinessServiceRepository businessServiceRepository) {

        this.profilePhotoRepository = profilePhotoRepository;
        this.backgroundPhotoRepository = backgroundPhotoRepository;
        this.companyRepository = companyRepository;
        this.customerRepository = customerRepository;
        this.businessServiceMediaRepository = businessServiceMediaRepository;
        this.businessServiceRepository = businessServiceRepository;
    }

    @Override
    public ProfilePhotoRespCompanyDTO addProfilePhotoToCompany(Long idCompany, ProfilePhotoDTO profilePhotoDTO) {

        Company company = companyRepository.getReferenceById(idCompany);
        if (company != null) {
            profilePhoto = new ProfilePhoto(profilePhotoDTO);
            profilePhoto.addCompany(company);
            profilePhotoRepository.save(profilePhoto);
            return new ProfilePhotoRespCompanyDTO(profilePhoto);
        }

        throw new IllegalArgumentException("This ID is null. Cannot be null.");
    }

    @Override
    public BackgroundPhotoRespCompanyDTO addBackgoudPhotoToCompany(Long idCompany, BackgroundPhotoDTO backgroundPhotoDTO) {

        Company company = companyRepository.getReferenceById(idCompany);
        if (company != null) {
            backgroundPhoto = new BackgroundPhoto(backgroundPhotoDTO);
            backgroundPhoto.addCompany(company);
            backgroundPhotoRepository.save(backgroundPhoto);
            return new BackgroundPhotoRespCompanyDTO(backgroundPhoto);
        }

        throw new IllegalArgumentException("This ID is null. Cannot be null.");
    }


    @Override
    public BackgroundPhotoRespCustomerDTO addBackgoudPhotoToCustomer(Long idCustomer,
                                                                     BackgroundPhotoDTO backgroundPhotoDTO) {

        Customer customer = customerRepository.getReferenceById(idCustomer);
        if (customer == null) {
            throw new IllegalArgumentException("This customer is null. Cannot be null.");
        }
        backgroundPhoto = new BackgroundPhoto(backgroundPhotoDTO);
        backgroundPhoto.addCustomer(customer);
        backgroundPhotoRepository.save(backgroundPhoto);
        return new BackgroundPhotoRespCustomerDTO(backgroundPhoto);

    }

    @Override
    public ProfilePhotoRespCustomerDTO addProfilePhotoToCustomer(Long idCustomer, ProfilePhotoDTO profilePhotoDTO) {

        Customer customer = customerRepository.getReferenceById(idCustomer);
        if (customer != null) {
            ProfilePhoto profilePhoto = new ProfilePhoto(profilePhotoDTO);
            profilePhoto.addCustomer(customer);
            profilePhotoRepository.save(profilePhoto);
            return new ProfilePhotoRespCustomerDTO(profilePhoto);
        }
        throw new IllegalArgumentException("This ID is null. Cannot be null.");
    }

    @Override
    public void deleteProfilePhoto(Long idPhoto) {
        profilePhotoRepository.deleteById(idPhoto);
    }

    @Override
    public void deleteBackgroundPhoto(Long idPhoto) {
        backgroundPhotoRepository.deleteById(idPhoto);
    }

    @Override
    public ProfilePhotoResponseDTO replaceProfilePhotoToCustomer(Long idCustomer, ProfilePhotoDTO profilePhotoDTO) {

        Customer customer = customerRepository.getReferenceById(idCustomer);
        if (customer == null) {
            throw new IllegalArgumentException("The customer is null. Cannot be null.");
        }
        ProfilePhoto existingProfilePhoto = profilePhotoRepository.findByCustomerId(idCustomer);
        if (existingProfilePhoto != null) {
            deleteProfilePhoto(existingProfilePhoto.getId());
        }
        ProfilePhoto profilePhoto = new ProfilePhoto(profilePhotoDTO);
        profilePhoto.addCustomer(customer);
        profilePhotoRepository.save(profilePhoto);
        return new ProfilePhotoResponseDTO(profilePhoto.getId(), profilePhoto.getUrl());
    }

    @Override
    public BackgroundPhotoResponseDTO replaceBackgroundPhotoToCustomer(Long idCustomer, BackgroundPhotoDTO backgroundPhotoDTO) {

        Customer customer = customerRepository.getReferenceById(idCustomer);
        if (customer == null) {
            throw new IllegalArgumentException("The customer is null. Cannot be null.");
        }
        BackgroundPhoto existingBackgroundPhoto = backgroundPhotoRepository.findByCustomerId(idCustomer);
        if (existingBackgroundPhoto != null) {
            deleteBackgroundPhoto(existingBackgroundPhoto.getId());
        }
        BackgroundPhoto backgroundPhoto = new BackgroundPhoto(backgroundPhotoDTO);
        backgroundPhoto.addCustomer(customer);
        backgroundPhotoRepository.save(backgroundPhoto);
        return new BackgroundPhotoResponseDTO(backgroundPhoto.getId(), backgroundPhoto.getUrl());
    }

    @Override
    public ProfilePhotoResponseDTO replaceProfilePhotoToCompany(Long idCompany, ProfilePhotoDTO profilePhotoDTO) {

        Company company = companyRepository.getReferenceById(idCompany);
        if (company == null) {
            throw new IllegalArgumentException("The company is null. Cannot be null.");
        }
        ProfilePhoto existingProfilePhoto = profilePhotoRepository.findByCompanyId(idCompany);
        if (existingProfilePhoto != null) {
            deleteProfilePhoto(existingProfilePhoto.getId());
        }
        ProfilePhoto profilePhoto = new ProfilePhoto(profilePhotoDTO);
        profilePhoto.addCompany(company);
        profilePhotoRepository.save(profilePhoto);
        return new ProfilePhotoResponseDTO(profilePhoto.getId(), profilePhoto.getUrl());
    }

    @Override
    public BackgroundPhotoResponseDTO replaceBackgroundPhotoToCompany(Long idCompany, BackgroundPhotoDTO backgroundPhotoDTO) {

        Company company = companyRepository.getReferenceById(idCompany);
        if (company == null) {
            throw new IllegalArgumentException("The company is null. Cannot be null.");
        }
        BackgroundPhoto existingBackgroundPhoto = backgroundPhotoRepository.findByCompanyId(idCompany);
        if (existingBackgroundPhoto != null) {
            deleteBackgroundPhoto(existingBackgroundPhoto.getId());
        }
        BackgroundPhoto backgroundPhoto = new BackgroundPhoto(backgroundPhotoDTO);
        backgroundPhoto.addCompany(company);
        backgroundPhotoRepository.save(backgroundPhoto);
        return new BackgroundPhotoResponseDTO(backgroundPhoto.getId(), backgroundPhoto.getUrl());
    }


    @Override
    public BusinessServiceMediaResponseDTO replaceBusinessServiceMediaToBusinessService(Long idBusinessService,
                                                                                        BusinessServiceMediaDTO businessServiceMediaDTO) {

        if (businessServiceMediaDTO == null) {
            throw new IllegalArgumentException("This BusinessServiceMedia is null. Cannot be null.");
        }
        BusinessService businessService = businessServiceRepository.getReferenceById(idBusinessService);
        if (businessService == null) {
            throw new IllegalArgumentException("This BusinessService is null. Cannot be null.");
        }
        BusinessServiceMedia businessServiceMedia = new BusinessServiceMedia(businessServiceMediaDTO);

        businessServiceMedia.addBusinessService(businessService);
        businessServiceMediaRepository.save(businessServiceMedia);
        return new BusinessServiceMediaResponseDTO(businessServiceMedia);
    }

    @Override
    public void deleteBusinessServiceMediaToBusinessService(Long idBusinessServiceMedia) {
        if (!businessServiceMediaRepository.existsById(idBusinessServiceMedia)) {
            throw new EntityNotFoundException("BusinessServiceMedia with ID " + idBusinessServiceMedia + " not found.");
        }
        businessServiceMediaRepository.deleteById(idBusinessServiceMedia);
        System.out.println("Se ha borrado la entidad con ID " + idBusinessServiceMedia);
    }


}
