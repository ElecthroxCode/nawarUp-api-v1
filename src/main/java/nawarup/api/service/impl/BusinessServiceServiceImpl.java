package nawarup.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nawarup.api.dto.BusinessServiceDTO;
import nawarup.api.models.BusinessService;
import nawarup.api.repository.BusinessServiceRepository;
import nawarup.api.service.BusinessServiceService;

@Service
public class BusinessServiceServiceImpl implements BusinessServiceService{
	
	@Autowired
	private BusinessServiceRepository businessServiceRepository;

	@Override
	public BusinessServiceDTO createBusinessService(BusinessServiceDTO businessServiceDTO) {
		BusinessService businessService = new BusinessService(businessServiceDTO);
		
		return new BusinessServiceDTO(businessServiceRepository.save(businessService));
	}

	@Override
	public BusinessServiceDTO updateBusinessService(BusinessServiceDTO businessServiceDTO) {
		BusinessService businessService = getBusinessService(businessServiceDTO.id());
		businessService.updateBusinessService(businessServiceDTO);
		return new BusinessServiceDTO(businessService);
	}


	@Override
	public BusinessService getBusinessService(Long idBusinessService) {
		
		
		return businessServiceRepository.getReferenceById(idBusinessService);
	}

	@Override
	public void deleteBusinessService(Long idBusinessService) {
		businessServiceRepository.deleteById(idBusinessService);
		
	}

	@Override
	public BusinessService getBusinessService(String name) {
		
		return businessServiceRepository.findByName(name);
	}

}
