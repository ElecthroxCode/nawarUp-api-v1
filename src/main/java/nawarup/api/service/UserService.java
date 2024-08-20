package nawarup.api.service;

import nawarup.api.dto.UserDTO;
import nawarup.api.dto.UserResponseDTO;
import nawarup.api.models.Company;
import nawarup.api.models.Customer;
import nawarup.api.models.User;

public interface UserService {
	
	public UserDTO createUser(UserDTO userDTO);
	public User getUser(Long idUser);
	public UserResponseDTO createUserToCompany(Company company);
	public UserResponseDTO createUserToCustomer(Customer customer);

}
