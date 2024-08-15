package nawarup.api.service;

import nawarup.api.dto.BackgroundPhotoDTO;
import nawarup.api.dto.CustomerDTO;
import nawarup.api.dto.ProfilePhotoDTO;
import nawarup.api.models.Customer;

public interface CustomerService {
	public CustomerDTO createCustomer(CustomerDTO customerDTO);
	public CustomerDTO updateCustomer(CustomerDTO customerDTO);
	public void deleteCustomer(Long idCustome);
	public ProfilePhotoDTO addProfilePhoto(ProfilePhotoDTO profilePhotoDTO);
	public BackgroundPhotoDTO addBackgroundPhoto(BackgroundPhotoDTO backgroundPhoto);
	public Customer getCustomer(Long idCustomer);
}
