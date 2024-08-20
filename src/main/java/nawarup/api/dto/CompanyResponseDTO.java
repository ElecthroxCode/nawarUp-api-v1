package nawarup.api.dto;

import nawarup.api.models.Company;

public record CompanyResponseDTO(
		Long id,
		String name,
		String manager,
		String phone,
		String email,
		String address,
		String description
		) {

	public CompanyResponseDTO(Company company) {
		this(company.getId(), company.getName(), company.getManager(), company.getPhone(),
				company.getEmail(), company.getAddress(), company.getDescription());
	}

}
