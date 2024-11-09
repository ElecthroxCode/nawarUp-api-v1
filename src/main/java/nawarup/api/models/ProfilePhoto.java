package nawarup.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nawarup.api.dto.ProfilePhotoDTO;

@Entity
@Table(name = "profile_photos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class ProfilePhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profile_photo")
    private Long id;
    private String url;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_company")
    private Company company;
    @OneToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    public ProfilePhoto(ProfilePhotoDTO profilePhotoDTO) {
        this.id = profilePhotoDTO.id();
        this.url = profilePhotoDTO.url();
    }

    public void updateProfilePhoto(ProfilePhotoDTO profilePhotoDTO) {
        if (profilePhotoDTO.url() != null) {
            this.url = profilePhotoDTO.url();
        }
    }

    public void addCompany(Company company) {
        this.company = company;
    }

    public void addCustomer(Customer customer) {
        this.customer = customer;
    }


}
