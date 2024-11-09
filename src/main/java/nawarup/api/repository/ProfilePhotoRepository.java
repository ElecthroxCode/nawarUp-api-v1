package nawarup.api.repository;

import nawarup.api.models.ProfilePhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfilePhotoRepository extends JpaRepository<ProfilePhoto, Long> {

    ProfilePhoto findByCompanyId(Long idCompany);

    ProfilePhoto findByCustomerId(Long idCustomer);

}
