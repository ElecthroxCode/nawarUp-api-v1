package nawarup.api.service.impl;

import jakarta.transaction.Transactional;
import nawarup.api.dto.*;
import nawarup.api.models.BusinessService;
import nawarup.api.models.Company;
import nawarup.api.models.User;
import nawarup.api.repository.BusinessServiceRepository;
import nawarup.api.repository.CompanyRepository;
import nawarup.api.repository.UserRepository;
import nawarup.api.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {


    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;
    private final BusinessServiceRepository businessServiceRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository, UserRepository userRepository,
                              BusinessServiceRepository businessServiceRepositor) {

        this.companyRepository = companyRepository;
        this.userRepository = userRepository;
        this.businessServiceRepository = businessServiceRepositor;
    }


    @Override
    public Page<CompanyListDTO> getAllCompany(Pageable pageable) {
        return companyRepository.findByActiveTrue(pageable).map(CompanyListDTO::new);
    }

    @Override
    public CompanyResponseDTO createCompany(CompanyDTO companyDTO) {

        if (companyDTO == null) {
            throw new IllegalArgumentException("Company cannot be null");
        }
        Company company = new Company(companyDTO);
        User user = new User(company);
        userRepository.save(user);
        company.addUser(user);
        companyRepository.save(company);
        return new CompanyResponseDTO(company);
    }

    @Transactional
    @Override
    public CompanyUpdateDTO updateCompany(CompanyUpdateDTO companyUpdateDTO) {

        if (companyUpdateDTO == null) {
            throw new IllegalArgumentException("This update is null. Company cannot be null");
        }
        Company company = getCompany(companyUpdateDTO.id());
        company.updateCompany(companyUpdateDTO);
        return new CompanyUpdateDTO(
                company.getId(), company.getName(), company.getManager(), company.getPhone(),
                company.getEmail(), company.getAddress(), company.getDescription()
        );
    }

    @Override
    public void deleteCompany(Long idCompany) {
        Company company = getCompany(idCompany);
        company.offCompany();
    }

    @Override
    public Company getCompany(Long idCompany) {

        return companyRepository.getReferenceById(idCompany);
    }

    @Override
    public Company getCompanyByIdUser(Long idUser) {
        return companyRepository.findByUser_Id(idUser);
    }

    @Override
    public BusinessServiceResponseDTO addBusinessServiceToCompany(Long idCompany, BusinessServiceDTO businessServiceDTO) {

        Company company = getCompany(idCompany);
        BusinessService businessService = new BusinessService(businessServiceDTO);
        if (company == null) {
            throw new IllegalArgumentException("This company is null. Cannot be null.");
        }

        businessService.addCompany(company);
        businessServiceRepository.save(businessService);
        return new BusinessServiceResponseDTO(businessService);
    }


    @Override
    public void deleteBusinessServiceToCompany(Long idBusinessService) {
        businessServiceRepository.deleteById(idBusinessService);

    }

    @Transactional
    @Override
    public BusinessServiceUpdateDTO updateBusinessServiceToCompany(BusinessServiceUpdateDTO businessServiceUpdateDTO) {
        BusinessService businessService = businessServiceRepository.getReferenceById(businessServiceUpdateDTO.id());
        businessService.updateBusinessService(businessServiceUpdateDTO);
        return new BusinessServiceUpdateDTO(
                businessService.getId(), businessService.getName(),
                businessService.getDescription(), businessService.getBasePrice()
        );
    }


}
