package nawarup.api.repository;

import nawarup.api.models.BackgroundPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BackgroundPhotoRepository extends JpaRepository<BackgroundPhoto, Long> {

    BackgroundPhoto findByCompanyId(Long idCompany);

    BackgroundPhoto findByCustomerId(Long id);

}
