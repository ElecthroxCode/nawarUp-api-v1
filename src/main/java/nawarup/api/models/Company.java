package nawarup.api.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nawarup.api.dto.CompanyDTO;
import nawarup.api.dto.CompanyUpdateDTO;

@Entity(name = "Company")
@Table(name = "companies")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_company")
	@EqualsAndHashCode.Include
	private Long id;
	private String name;
	private String manager;
	private String phone;
	private String email;
	private String address;
	private String description;
	private String username;
	private String password;
	
	
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<BusinessService> allBusinessServices = new HashSet<>();
	
	public Company(CompanyDTO companyDTO) {
		this.name = companyDTO.name();
		this.manager = companyDTO.manager();
		this.phone = companyDTO.phone();
		this.email = companyDTO.email();
		this.address = companyDTO.address();
		this.description = companyDTO.description();
		this.username = companyDTO.username();
		this.password = companyDTO.password();
	}
	
	public void updateCompany(CompanyUpdateDTO companyUpdateDTO) {
		if(companyUpdateDTO.name() != null) {
			this.name = companyUpdateDTO.name();
		}
		if(companyUpdateDTO.manager() != null) {
			this.manager = companyUpdateDTO.manager();
		}
		if(companyUpdateDTO.phone() != null) {
			this.phone = companyUpdateDTO.phone();
		}
		if(companyUpdateDTO.address() != null) {
			this.address = companyUpdateDTO.address();
		}
		if(companyUpdateDTO.description() != null) {
			this.description = companyUpdateDTO.description();
		}
	}
	
	public void offCompany() {
		
		
	}

	public void addBusinessService(BusinessService businessService) {
		this.getAllBusinessServices().add(businessService);
		businessService.addCompany(this);
		
	}
	
	

}
