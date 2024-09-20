package nawarup.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nawarup.api.models.BusinessServiceMedia;

public interface BusinessServiceMediaRepository extends JpaRepository<BusinessServiceMedia, Long>{

	 BusinessServiceMedia findByBusinessServiceId(Long businessServiceId);
}
