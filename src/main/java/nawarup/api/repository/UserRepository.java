package nawarup.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nawarup.api.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
