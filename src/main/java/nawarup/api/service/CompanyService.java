package nawarup.api.service;


import nawarup.api.dto.*;
import nawarup.api.models.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CompanyService {
    public Page<CompanyListDTO> getAllCompany(Pageable pageable);

    public CompanyResponseDTO createCompany(CompanyDTO companyDTO);

    public CompanyUpdateDTO updateCompany(CompanyUpdateDTO companyUpdateDTO);

    public void deleteCompany(Long idCompany);

    public Company getCompany(Long idCompany);

    public Company getCompanyByIdUser(Long idUser);

    public BusinessServiceResponseDTO addBusinessServiceToCompany(Long idCompany, BusinessServiceDTO businessServiceDTO);

    public BusinessServiceUpdateDTO updateBusinessServiceToCompany(BusinessServiceUpdateDTO businessServiceUpdateDTO);

    public void deleteBusinessServiceToCompany(Long idBusinessService);
}
