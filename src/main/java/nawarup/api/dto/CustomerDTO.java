package nawarup.api.dto;

public record CustomerDTO(
		Long id,
		String name,
		String phone,
		String email,
		String address,
		String description,
		UserDTO userDTO
		) {

}
