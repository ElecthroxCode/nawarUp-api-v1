package nawarup.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import nawarup.api.dto.CompanyDTO;
import nawarup.api.dto.CompanyUpdateDTO;
import nawarup.api.dto.UserDTO;
import nawarup.api.models.Company;
import nawarup.api.models.User;
import nawarup.api.repository.CompanyRepository;
import nawarup.api.repository.UserRepository;
import nawarup.api.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private UserServiceImpl userServiceImpl;
	

	
	@Override
	public CompanyDTO createCompany(CompanyDTO companyDTO) {
	
		 if (companyDTO == null) {
		        throw new IllegalArgumentException("Company cannot be null");
		    }
		    UserDTO userDTO = companyDTO.user();
		    if (userDTO == null) {
		        throw new IllegalArgumentException("User cannot be null");
		    }
		    UserDTO newUserDTO = userServiceImpl.createUserDTO(userDTO);
		    Company company = new Company(companyDTO);
		    company.addUser(new User(newUserDTO));
		    
		return new CompanyDTO(companyRepository.save(company));
		
	}

	@Override
	public CompanyUpdateDTO updateCompany(CompanyUpdateDTO companyUpdateDTO) {
		if(companyUpdateDTO == null) {
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

	

}
