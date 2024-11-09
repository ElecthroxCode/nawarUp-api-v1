package nawarup.api.repository;

import nawarup.api.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByUser_Id(Long idUser);
}
