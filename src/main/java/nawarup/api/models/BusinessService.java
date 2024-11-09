package nawarup.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nawarup.api.dto.BusinessServiceDTO;
import nawarup.api.dto.BusinessServiceUpdateDTO;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "BusinessService")
@Table(name = "services")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BusinessService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_service")
    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private String description;
    @Column(name = "base_price")
    private BigDecimal basePrice;
    @ManyToOne
    @JoinColumn(name = "id_company")
    private Company company;
    @OneToMany(mappedBy = "businessService", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Reservation> reservation = new HashSet<>();

    public BusinessService(BusinessServiceDTO businessServiceDTO) {
        this.id = businessServiceDTO.id();
        this.name = businessServiceDTO.name();
        this.description = businessServiceDTO.description();
        this.basePrice = businessServiceDTO.basePrice();

    }

    public void updateBusinessService(BusinessServiceUpdateDTO businessServiceUpdateDTO) {
        if (businessServiceUpdateDTO.name() != null) {
            this.name = businessServiceUpdateDTO.name();
        }
        if (businessServiceUpdateDTO.description() != null) {
            this.description = businessServiceUpdateDTO.description();
        }
        if (businessServiceUpdateDTO.basePrice() != null) {
            this.basePrice = businessServiceUpdateDTO.basePrice();
        }

    }

    public void addCompany(Company company) {
        this.company = company;

    }

    public void updateBusinessService(BusinessServiceDTO businessServiceDTO) {
        if (businessServiceDTO.name() != null) {
            this.name = businessServiceDTO.name();
        }
        if (businessServiceDTO.description() != null) {
            this.description = businessServiceDTO.description();
        }
        if (businessServiceDTO.basePrice() != null) {
            this.basePrice = businessServiceDTO.basePrice();
        }

    }
}
