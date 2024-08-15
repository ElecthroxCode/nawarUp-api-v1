package nawarup.api.service;

import nawarup.api.dto.BusinessServiceDTO;

import nawarup.api.models.BusinessService;

public interface BusinessServiceService {

	public BusinessServiceDTO createBusinessService(BusinessServiceDTO businessServiceDTO);
	public BusinessServiceDTO updateBusinessService(BusinessServiceDTO businessServiceDTO);
	public void deleteBusinessService(Long idBusinessService);
	public BusinessService getBusinessService(Long idBusinessService);
	public BusinessService getBusinessService(String name);
}
