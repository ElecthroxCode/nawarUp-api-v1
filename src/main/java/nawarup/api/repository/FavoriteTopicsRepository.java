package nawarup.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nawarup.api.models.FavoriteTopics;

public interface FavoriteTopicsRepository extends JpaRepository<FavoriteTopics, Long>{

}
