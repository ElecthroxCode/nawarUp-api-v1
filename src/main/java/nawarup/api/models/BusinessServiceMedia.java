package nawarup.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "services_media")
@NoArgsConstructor
@AllArgsConstructor
@Getter	
@EqualsAndHashCode
public class BusinessServiceMedia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_business_service_media")
	private Long id;
	private String url;
	@Column(name = "design_type")
	private String designType = "1";
	
	
}
