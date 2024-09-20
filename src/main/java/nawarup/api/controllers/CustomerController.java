package nawarup.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

import nawarup.api.dto.CustomerDTO;
import nawarup.api.dto.CustomerResponseDTO;
import nawarup.api.dto.CustomerUpdateDTO;
import nawarup.api.dto.FavoriteTopicsDTO;
import nawarup.api.dto.FavoriteTopicsResponseDTO;
import nawarup.api.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	private final CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@PostMapping
	public ResponseEntity<CustomerResponseDTO> createCustomer(@RequestBody CustomerDTO customer, UriComponentsBuilder uriComponentsBuilder){
		
		CustomerResponseDTO customerResponseDTO = customerService.createCustomer(customer);
		URI url = uriComponentsBuilder.path("/{id}").buildAndExpand(customerResponseDTO.id()).toUri();
		return ResponseEntity.created(url).body(customerResponseDTO);
	}
	
	@PutMapping
	public ResponseEntity<CustomerUpdateDTO> updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
		
		return ResponseEntity.ok(customerService.updateCustomer(customerUpdateDTO));
	}
	
	@PostMapping("/topics/{idCustomer}")
	public ResponseEntity<FavoriteTopicsResponseDTO> addFavoriteTopicsToCustomer(@PathVariable Long idCustomer, @RequestBody FavoriteTopicsDTO favoriteTopicsDTO,
			UriComponentsBuilder uriComponentsBuilder){
		
		FavoriteTopicsResponseDTO favoriteTopicsResponseDTO = customerService.addFavoriteTopicsToCustomer(idCustomer, favoriteTopicsDTO);
		URI url = uriComponentsBuilder.path("/topics-customer/{id}").buildAndExpand(favoriteTopicsResponseDTO.id()).toUri();
		return ResponseEntity.created(url).body(favoriteTopicsResponseDTO);
	}
	
	@DeleteMapping("/idCustomer")
	public ResponseEntity<Void> deleteCustomer(@PathVariable Long idCustomer){
		
		customerService.deleteCustomer(idCustomer);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/topics/remove/{idFavoriteTopics}")
	public ResponseEntity<Void> deleteFavoriteTopicsToCustomer(@PathVariable Long idFavoriteTopics){
		customerService.deleteFavoriteTopicsToCustomer(idFavoriteTopics);
		return ResponseEntity.noContent().build();
	}
	
	
}
