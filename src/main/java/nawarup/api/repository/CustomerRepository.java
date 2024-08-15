package nawarup.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nawarup.api.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
