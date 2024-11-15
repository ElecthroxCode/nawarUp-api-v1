package nawarup.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nawarup.api.dto.CustomerDTO;
import nawarup.api.dto.CustomerUpdateDTO;

import java.util.HashSet;
import java.util.Set;

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
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id", referencedColumnName = "id_user")
    private User user;
    private String username;
    private String password;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Reservation> reservation = new HashSet<>();

    public Customer(CustomerDTO customerDTO) {
        this.name = customerDTO.name();
        this.phone = customerDTO.phone();
        this.email = customerDTO.email();
        this.address = customerDTO.address();
        this.description = customerDTO.description();
        this.username = customerDTO.username();
        this.password = customerDTO.password();
    }

    public void updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if (customerUpdateDTO.name() != null) {
            this.name = customerUpdateDTO.name();
        }
        if (customerUpdateDTO.phone() != null) {
            this.phone = customerUpdateDTO.phone();
        }
        if (customerUpdateDTO.address() != null) {
            this.address = customerUpdateDTO.address();
        }
        if (customerUpdateDTO.description() != null) {
            this.description = customerUpdateDTO.description();
        }
    }

    public void offCustomer() {

    }
    public void addUser(User user){
        this.user = user;
    }

}
