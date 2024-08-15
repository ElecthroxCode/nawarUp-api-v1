package nawarup.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "FavoriteTopics")
@Table(name = "favorite_topics")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteTopics {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_favorite_topics")
	private Long id;
	private String name;
	
}
