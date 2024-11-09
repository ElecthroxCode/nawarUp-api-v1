package nawarup.api.repository;

import nawarup.api.models.FavoriteTopics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteTopicsRepository extends JpaRepository<FavoriteTopics, Long> {

}
