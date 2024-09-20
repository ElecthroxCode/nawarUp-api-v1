package nawarup.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import nawarup.api.dto.ReservationDTO;
import nawarup.api.dto.ReservationResponseDTO;
import nawarup.api.models.BusinessService;
import nawarup.api.models.BusinessServiceMedia;
import nawarup.api.models.Customer;
import nawarup.api.models.Reservation;
import nawarup.api.repository.BusinessServiceMediaRepository;
import nawarup.api.repository.BusinessServiceRepository;
import nawarup.api.repository.CustomerRepository;
import nawarup.api.repository.ReservationRepository;
import nawarup.api.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{
	
	private final CustomerRepository customerRepository;
	private final BusinessServiceRepository businessServiceRepository;
	private final ReservationRepository reservationRepository;
	private final BusinessServiceMediaRepository businessServiceMediaRepository;
	
	@Autowired
	public ReservationServiceImpl(CustomerRepository customerRepository, BusinessServiceRepository businessServiceRepository,
			ReservationRepository reservationRepository, BusinessServiceMediaRepository businessServiceMediaRepositor) {
		this.customerRepository = customerRepository;
		this.businessServiceRepository =businessServiceRepository;
		this.reservationRepository= reservationRepository;
		this.businessServiceMediaRepository = businessServiceMediaRepositor;
	}
	
	@Override
	public ReservationResponseDTO addReservationToCustomer(Long idCustomer, Long idBusinessService,
			ReservationDTO reservationDTO, Long idBusinessServiceMedia) {
		
		if(!customerRepository.existsById(idCustomer)) {
			throw new EntityNotFoundException("This entity Customer not exist.");
		}
		if(!businessServiceRepository.existsById(idBusinessService)) {
			throw new EntityNotFoundException("This entity BusinessService not exist.");
		}
		Customer customer = customerRepository.getReferenceById(idCustomer);
		BusinessService businessService = businessServiceRepository.getReferenceById(idBusinessService);
		if(!businessServiceMediaRepository.existsById(idBusinessServiceMedia)) {
			throw new EntityNotFoundException("This entity BusinessServiceMedia not exist.");
		}
		BusinessServiceMedia businessServiceMedia = businessServiceMediaRepository.getReferenceById(idBusinessServiceMedia);
		Reservation reservation = new Reservation(reservationDTO);
		reservation.addCustomer(customer);
		reservation.addBusinessService(businessService);
		reservation.reservationAddValues(businessService.getName(), businessService.getBasePrice());
		reservation.fullPayment(1.15, businessServiceMedia.getDesignType());
		reservationRepository.save(reservation);
		return new ReservationResponseDTO(reservation);
	}

	@Override
	public void deleteReservationToCustomer(Long idReservaion) {
		if(!reservationRepository.existsById(idReservaion)) {
			throw new EntityNotFoundException("This entity not exist.");
		}
		reservationRepository.deleteById(idReservaion);
	}

}
