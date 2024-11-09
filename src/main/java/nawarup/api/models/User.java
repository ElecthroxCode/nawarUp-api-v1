package nawarup.api.models;

import jakarta.persistence.*;
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
    @OneToOne(mappedBy = "user")
    private Company company;
    @OneToOne(mappedBy = "user")
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
        this.userType = UserType.COMPANY;
    }

    public User(Customer customer) {
        this.username = customer.getUsername();
        this.password = customer.getPassword();
        this.email = customer.getEmail();
        this.userType = UserType.CUSTOMER;

    }
}



