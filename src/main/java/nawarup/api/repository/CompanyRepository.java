package nawarup.api.repository;


import nawarup.api.models.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Page<Company> findByActiveTrue(Pageable pageable);

    Company findByUser_Id(Long idUser);
}
