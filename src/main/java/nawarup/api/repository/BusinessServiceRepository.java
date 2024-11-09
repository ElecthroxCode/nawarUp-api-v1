package nawarup.api.repository;

import nawarup.api.models.BusinessService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessServiceRepository extends JpaRepository<BusinessService, Long> {

    public BusinessService findByName(String name);

}
