package nawarup.api.dto;

public record CompanyUpdateDTO(
        Long id,
        String name,
        String manager,
        String phone,
        String email,
        String address,
        String description
) {

}
