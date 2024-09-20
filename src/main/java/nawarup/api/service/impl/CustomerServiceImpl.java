package nawarup.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import nawarup.api.dto.CustomerDTO;
import nawarup.api.dto.CustomerResponseDTO;
import nawarup.api.dto.CustomerUpdateDTO;
import nawarup.api.dto.FavoriteTopicsDTO;
import nawarup.api.dto.FavoriteTopicsResponseDTO;
import nawarup.api.models.Customer;
import nawarup.api.models.FavoriteTopics;
import nawarup.api.models.User;
import nawarup.api.repository.CustomerRepository;
import nawarup.api.repository.FavoriteTopicsRepository;
import nawarup.api.repository.UserRepository;
import nawarup.api.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	private final CustomerRepository customerRepository;
	private final UserRepository userRepository;
	private final FavoriteTopicsRepository favoriteTopicsRepository;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository, UserRepository userRepository,
			FavoriteTopicsRepository favoriteTopicsRepository) {
		this.customerRepository = customerRepository;
		this.userRepository = userRepository;
		this.favoriteTopicsRepository = favoriteTopicsRepository;
	}
	
	@Override
	public CustomerResponseDTO createCustomer(CustomerDTO customerDTO) {
		if(customerDTO == null) {
			throw new IllegalArgumentException("This customer is null. Cannot be null.");
		}
		Customer customer = new Customer(customerDTO);
		User user = new User(customer);
		customerRepository.save(customer);
		userRepository.save(user);
		
		return new CustomerResponseDTO(customer);
	}
	
	@Transactional
	@Override
	public CustomerUpdateDTO updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
		Customer customer = getCustomer(customerUpdateDTO.id());
		if(customer == null) {
			throw new IllegalArgumentException("This customer is null. Cannot be null.");
		}
		customer.updateCustomer(customerUpdateDTO);
		return new CustomerUpdateDTO(
				customer.getId(), customer.getName(), customer.getPhone(), customer.getEmail(),
				customer.getAddress(), customer.getDescription()
				);
	}

	@Override
	public void permanentDeleteCustomer(Long idCustome) {
		customerRepository.deleteById(idCustome);
	}

	@Override
	public Customer getCustomer(Long idCustomer) {
		return customerRepository.getReferenceById(idCustomer);
	}

	@Override
	public void deleteCustomer(Long idCustomer) {
		Customer customer = getCustomer(idCustomer);
		if(customer == null) {
			throw new IllegalArgumentException("This customer is null. Cannot be null.");
		}
		customer.offCustomer();
	}

	@Override
	public FavoriteTopicsResponseDTO addFavoriteTopicsToCustomer(Long idCustomer, FavoriteTopicsDTO favoriteTopicsDTO) {
		
		if(!customerRepository.existsById(idCustomer)) {
			throw new EntityNotFoundException("This idCustomer is null. Cannot be null.");
		}
		Customer customer = getCustomer(idCustomer);
		FavoriteTopics favoriteTopics = new FavoriteTopics(favoriteTopicsDTO);
		favoriteTopics.addCustomer(customer);
		favoriteTopicsRepository.save(favoriteTopics);
		return new FavoriteTopicsResponseDTO(favoriteTopics);
	}

	@Override
	public void deleteFavoriteTopicsToCustomer(Long idFavoriteTopics) {
		if(!favoriteTopicsRepository.existsById(idFavoriteTopics)) {
			throw new EntityNotFoundException("This idFavoriteTopics not exist.");
		}
		favoriteTopicsRepository.deleteById(idFavoriteTopics);
	}
	
	
	

}
