package nawarup.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nawarup.api.dto.BackgroundPhotoDTO;

@Entity
@Table(name = "background_photos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class BackgroundPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_background_photo")
    private Long id;
    private String url;
    @OneToOne
    @JoinColumn(name = "id_company")
    private Company company;
    @OneToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    public BackgroundPhoto(BackgroundPhotoDTO backgroundPhotoDTO) {
        this.id = backgroundPhotoDTO.id();
        this.url = backgroundPhotoDTO.url();
    }

    public void updateBackgroundPhoto(BackgroundPhotoDTO backgroundPhotoDTO) {
        if (backgroundPhotoDTO.url() != null) {
            this.url = backgroundPhotoDTO.url();
        }
    }

    public void addCompany(Company company) {
        this.company = company;
    }

    public void addCustomer(Customer customer) {
        this.customer = customer;
    }

}

