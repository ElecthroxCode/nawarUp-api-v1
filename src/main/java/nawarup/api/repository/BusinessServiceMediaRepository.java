package nawarup.api.repository;

import nawarup.api.models.BusinessServiceMedia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessServiceMediaRepository extends JpaRepository<BusinessServiceMedia, Long> {

    BusinessServiceMedia findByBusinessServiceId(Long businessServiceId);
}
