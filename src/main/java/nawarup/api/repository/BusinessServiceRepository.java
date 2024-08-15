package nawarup.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nawarup.api.models.BusinessService;

public interface BusinessServiceRepository extends JpaRepository<BusinessService, Long> {

	public BusinessService findByName(String name);

}
