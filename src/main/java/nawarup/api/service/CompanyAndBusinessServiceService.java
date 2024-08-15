package nawarup.api.service;

import nawarup.api.dto.BusinessServiceDTO;

public interface CompanyAndBusinessServiceService {
	

	
	public BusinessServiceDTO addBusinessServiceToCompany(Long idCompany, BusinessServiceDTO businessServiceDTO);
	
	public BusinessServiceDTO updateBusinessService(BusinessServiceDTO businessServiceDTO);
	
	public void deleteBusinessService(Long idBusinessService);
}
