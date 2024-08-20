package nawarup.api.service;


import nawarup.api.dto.BusinessServiceDTO;
import nawarup.api.dto.BusinessServiceResponseDTO;
import nawarup.api.dto.BusinessServiceUpdateDTO;
import nawarup.api.dto.CompanyDTO;
import nawarup.api.dto.CompanyResponseDTO;
import nawarup.api.dto.CompanyUpdateDTO;
import nawarup.api.models.Company;

public interface CompanyService {
	
	public CompanyResponseDTO createCompany(CompanyDTO companyDTO);
	public CompanyUpdateDTO updateCompany(CompanyUpdateDTO companyUpdateDTO);
	public void deleteCompany(Long idCompany);
	public Company getCompany(Long idCompany);
	public BusinessServiceResponseDTO addBusinessServiceToCompany(Long idCompany, BusinessServiceDTO businessServiceDTO);
	public BusinessServiceUpdateDTO updateBusinessServiceToCompany(BusinessServiceUpdateDTO businessServiceUpdateDTO);
	public void deleteBusinessServiceToCompany(Long idBusinessService);
}
