package nawarup.api.dto;

import nawarup.api.models.Customer;

public record CustomerResponseDTO(
		Long id,
		String name,
		String phone,
		String email,
		String address,
		String description
		) {
	public CustomerResponseDTO(Customer customer) {
		this(customer.getId(), customer.getName(), customer.getPhone(), customer.getEmail(),
				customer.getAddress(), customer.getDescription());
	}
	
}
