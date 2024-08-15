package nawarup.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nawarup.api.dto.UserDTO;
import nawarup.api.models.User;
import nawarup.api.repository.UserRepository;
import nawarup.api.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDTO createUserDTO(UserDTO userDTO) {
		
		return new UserDTO(userRepository.save(new User(userDTO)));
	}

	@Override
	public User getUser(Long idUser) {
		
		return userRepository.getReferenceById(idUser);
	}

}
