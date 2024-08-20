package nawarup.api.dto;

import nawarup.api.models.Customer;

public record CustomerDTO(
		Long id,
		String name,
		String phone,
		String email,
		String address,
		String description,
		String username,
		String password
		) {
	public CustomerDTO(Customer customer) {
		this(customer.getId(), customer.getName(), customer.getPhone(), customer.getEmail(),
				customer.getAddress(), customer.getDescription(), customer.getUsername(),
				customer.getPassword());
	}
}
