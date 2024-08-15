package nawarup.api.dto;

import nawarup.api.models.Company;

public record CompanyDTO(
		Long id,
		String name,
		String manager,
		String phone,
		String email,
		String address,
		String description,
		UserDTO user
		) {

	public CompanyDTO(Company company) {
		this(company.getId(), company.getName(), company.getManager(), company.getPhone(),
				company.getEmail(), company.getAddress(), company.getAddress(), 
				new UserDTO(company.getUser()));
	}

}
