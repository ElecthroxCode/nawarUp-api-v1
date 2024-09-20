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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nawarup.api.dto.BusinessServiceMediaDTO;

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
	private String designType;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_service")
	private BusinessService businessService;
	
	public BusinessServiceMedia(BusinessServiceMediaDTO businessServiceMediaDTO) {
		this.id = businessServiceMediaDTO.id();
		this.url = businessServiceMediaDTO.url();
		this.designType = businessServiceMediaDTO.designType();
	}
	
	public void addBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}
}
