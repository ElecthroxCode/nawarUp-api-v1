package nawarup.api.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nawarup.api.dto.CustomerDTO;

@Entity(name = "Customer")
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_customer")
	private Long id;
	private String name;
	private String phone;
	private String email;
	private String address;
	private String description;
	@OneToOne
	@JoinColumn(name = "id_user")
	private User user;
	@OneToOne
	@JoinColumn(name = "id_profile_photo")
	private ProfilePhoto urlProfilePhoto;
	@OneToOne
	@JoinColumn(name = "id_background_photo")
	private BackgroundPhoto urlBackPhoto;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Reservation> reservation = new HashSet<>();
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<FavoriteTopics> allFavoriteTopics = new HashSet<>();
	
	public Customer(CustomerDTO customerDTO) {
		this.name = customerDTO.name();
		this.phone = customerDTO.phone();
		this.email = customerDTO.email();
		this.address = customerDTO.address();
		this.user = new User(customerDTO.userDTO());
	}
	
}
