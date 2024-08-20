package nawarup.api.service;

import nawarup.api.dto.CustomerDTO;
import nawarup.api.dto.CustomerResponseDTO;
import nawarup.api.dto.CustomerUpdateDTO;
import nawarup.api.dto.FavoriteTopicsDTO;
import nawarup.api.dto.FavoriteTopicsResponseDTO;
import nawarup.api.models.Customer;

public interface CustomerService {
	public CustomerResponseDTO createCustomer(CustomerDTO customerDTO);
	public CustomerUpdateDTO updateCustomer(CustomerUpdateDTO customerUpdateDTO);
	public void permanentDeleteCustomer(Long idCustomer);
	public Customer getCustomer(Long idCustomer);
	public void deleteCustomer(Long idCustomer);
	public FavoriteTopicsResponseDTO addFavoriteTopicsToCustomer(Long idCustomer, FavoriteTopicsDTO favoriteTopicsDTO);
}
