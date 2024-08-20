package nawarup.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nawarup.api.models.BackgroundPhoto;

public interface BackgroundPhotoRepository extends JpaRepository<BackgroundPhoto, Long>{

	BackgroundPhoto findByCompanyId(Long idCompany);

	BackgroundPhoto findByCustomerId(Long id);

}
