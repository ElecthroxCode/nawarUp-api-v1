package nawarup.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nawarup.api.dto.UserDTO;

@Entity(name = "User")
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private Long id;
	private String username;
	private String password;
	private String email;
	@OneToOne
	@JoinColumn(name = "id_company")
	private Company company;
	@OneToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;
	@Enumerated(EnumType.STRING)
	@Column(name = "user_type")
	private UserType userType;
	
	
	public User(UserDTO userDTO) {
		this.id = userDTO.id();
		this.username = userDTO.username();
		this.password = userDTO.password();
		this.email = userDTO.email();
		this.userType = userDTO.userType();
	}
	
	public User(Company company) {
		this.username = company.getUsername();
		this.password = company.getPassword();
		this.email = company.getEmail();
		this.company = company;
		this.userType = UserType.COMPANY;
	}
	public User(Customer customer) {
		this.username = customer.getUsername();
		this.password = customer.getPassword();
		this.email = customer.getEmail();
		this.customer = customer;
		this.userType = UserType.CUSTOMER;
	
	}
}



