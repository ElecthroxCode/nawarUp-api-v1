package nawarup.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nawarup.api.dto.CompanyDTO;
import nawarup.api.dto.CompanyListDTO;
import nawarup.api.dto.CompanyUpdateDTO;

import java.util.HashSet;
import java.util.Set;

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
    private Boolean active;
    private String description;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id", referencedColumnName = "id_user")
    private User user;
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
        this.active = true;
        this.description = companyDTO.description();
        this.username = companyDTO.username();
        this.password = companyDTO.password();
    }
    public Company(CompanyListDTO companyListDTO){
        this.id = companyListDTO.id();
        this.name = companyListDTO.name();
        this.manager = companyListDTO.manager();
        this.phone = companyListDTO.phone();
        this.email = companyListDTO.email();
        this.address = companyListDTO.address();
        this.description = companyListDTO.description();
    }
    public void updateCompany(CompanyUpdateDTO companyUpdateDTO) {
        if (companyUpdateDTO.name() != null) {
            this.name = companyUpdateDTO.name();
        }
        if (companyUpdateDTO.manager() != null) {
            this.manager = companyUpdateDTO.manager();
        }
        if (companyUpdateDTO.phone() != null) {
            this.phone = companyUpdateDTO.phone();
        }
        if (companyUpdateDTO.address() != null) {
            this.address = companyUpdateDTO.address();
        }
        if (companyUpdateDTO.description() != null) {
            this.description = companyUpdateDTO.description();
        }
    }

    public void offCompany() {
    this.active = false;
    }
    public void addUser(User user){
        this.user = user;
    }
    public void addBusinessService(BusinessService businessService) {
        this.getAllBusinessServices().add(businessService);
        businessService.addCompany(this);

    }


}
