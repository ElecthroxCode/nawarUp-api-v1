package nawarup.api.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
import nawarup.api.dto.ReservationDTO;

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
	
	public Reservation(ReservationDTO reservationDTO) {
		this.id = reservationDTO.id();
		this.personServed = reservationDTO.personServed();
		this.details = reservationDTO.details();
		this.date = reservationDTO.date();
	
	}
	 //toma en cuenta un factor y el tipo de diseño para modificar el precio final.
	public void fullPayment(double factorForPrice, String designType) {
		BigDecimal factor;
		if(designType.equals("1")) {
			factor = new BigDecimal(Double.toString(factorForPrice));
			this.totalPayment = this.totalPayment.multiply(factor).setScale(3, RoundingMode.HALF_UP);
		}
		//tiene en cuenta la cantidad de persona a atender (valor del servicio * cantidad de persona)
		if(this.personServed > 1) {
			factor = new BigDecimal(Double.toString(this.personServed));
			this.totalPayment = this.totalPayment.multiply(factor).setScale(3, RoundingMode.HALF_UP);
		}
	}
	
	public void reservationAddValues(String addDetails, BigDecimal totalPayment) {
		this.details = String.format("Servicio: %s.%n%s", addDetails, this.details);
		this.totalPayment = totalPayment;
	}
	
	public void addCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void addBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}
}
