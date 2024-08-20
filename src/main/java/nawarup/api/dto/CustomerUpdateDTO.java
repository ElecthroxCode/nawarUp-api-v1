package nawarup.api.dto;

public record CustomerUpdateDTO(
		Long id,
		String name,
		String phone,
		String email,
		String address,
		String description
		) {

}
