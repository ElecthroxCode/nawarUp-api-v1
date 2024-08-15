package nawarup.api.service;

import nawarup.api.dto.UserDTO;
import nawarup.api.models.User;

public interface UserService {
	
	public UserDTO createUserDTO(UserDTO userDTO);
	public User getUser(Long idUser);

}
