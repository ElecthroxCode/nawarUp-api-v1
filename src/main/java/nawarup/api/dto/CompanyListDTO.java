package nawarup.api.dto;

import nawarup.api.models.BusinessService;
import nawarup.api.models.Company;

import java.util.List;

public record CompanyListDTO(
        Long id,
        String name,
        String manager,
        String phone,
        String email,
        String address,
        String description,
        List<BusinessServiceResponseDTO> businessServices
) {
    public CompanyListDTO(Company company){
        this(company.getId(), company.getName(), company.getManager(), company.getPhone(),
                company.getEmail(), company.getAddress(), company.getDescription(),
                company.getAllBusinessServices().stream().map(BusinessServiceResponseDTO::new).toList());
    }
}
