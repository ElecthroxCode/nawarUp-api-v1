package nawarup.api.service;


import nawarup.api.dto.CompanyDTO;
import nawarup.api.dto.CompanyUpdateDTO;
import nawarup.api.models.Company;

public interface CompanyService {
	
	public CompanyDTO createCompany(CompanyDTO companyDTO);
	public CompanyUpdateDTO updateCompany(CompanyUpdateDTO companyUpdateDTO);
	public void deleteCompany(Long idCompany);
	public Company getCompany(Long idCompany);
}
