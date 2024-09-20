package nawarup.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nawarup.api.dto.FavoriteTopicsDTO;

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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_customer")
	private Customer customer;
	
	public FavoriteTopics(FavoriteTopicsDTO favoriteTopicsDTO) {
		this.id = favoriteTopicsDTO.id();
		this.name = favoriteTopicsDTO.name();
	}
	
	public void addCustomer(Customer customer) {
		this.customer = customer;
	}
}
