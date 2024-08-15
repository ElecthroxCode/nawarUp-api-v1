package nawarup.api.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Reservation")
@Table(name = "reservations")
@NoArgsConstructor
@AllArgsConstructor
@Getter	
@EqualsAndHashCode
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_reservation")
	private Long id;
	@Column(name = "person_served")
	private int personServed;
	private String details;
	@Temporal(TemporalType.DATE)
	private LocalDate date;
	@Column(name = "total_payment")
	private BigDecimal totalPayment;
	@ManyToOne
	@JoinColumn(name = "id_service")
	private BusinessService businessService;
	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;
	


}
