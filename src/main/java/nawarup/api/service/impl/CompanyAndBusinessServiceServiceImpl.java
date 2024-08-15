package nawarup.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import nawarup.api.dto.BusinessServiceDTO;
import nawarup.api.models.BusinessService;
import nawarup.api.models.Company;
import nawarup.api.service.CompanyAndBusinessServiceService;

@Service
public class CompanyAndBusinessServiceServiceImpl implements CompanyAndBusinessServiceService{
	@Autowired
	private CompanyServiceImpl companyServiceImpl;
	@Autowired
	private BusinessServiceServiceImpl businessServiceServiceImpl;
	
	@Transactional
	@Override
	public BusinessServiceDTO addBusinessServiceToCompany(Long idCompany, BusinessServiceDTO businessServiceDTO) {
		
		if(businessServiceDTO == null) {
			throw new IllegalArgumentException("BusinessService cannot be null");
		}
		Company company = companyServiceImpl.getCompany(idCompany);
		BusinessService businessService = new BusinessService(businessServiceDTO);
		if(company == null){
			throw new IllegalArgumentException("Company cannot be null");
		}
			 //add BusinessService to company
		company.addBusinessService(businessService);
	
		return new BusinessServiceDTO(businessServiceServiceImpl.getBusinessService(businessService.getName()));
	}
	
	@Transactional
	@Override
	public BusinessServiceDTO updateBusinessService(BusinessServiceDTO businessServiceDTO) {
		
		return businessServiceServiceImpl.updateBusinessService(businessServiceDTO);
	}
	
	@Transactional
	@Override
	public void deleteBusinessService(Long idBusinessService) {
		businessServiceServiceImpl.deleteBusinessService(idBusinessService);
		
	}

}
