package nawarup.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nawarup.api.models.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{

}
