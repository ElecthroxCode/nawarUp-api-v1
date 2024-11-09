package nawarup.api.service.impl;

import nawarup.api.dto.UserDTO;
import nawarup.api.dto.UserLoginDTO;
import nawarup.api.dto.UserResponseDTO;
import nawarup.api.models.Company;
import nawarup.api.models.Customer;
import nawarup.api.models.User;
import nawarup.api.repository.UserRepository;
import nawarup.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    CompanyServiceImpl companyServiceImpl;

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        return new UserDTO(userRepository.save(new User(userDTO)));
    }

    @Override
    public User getUser(Long idUser) {

        return userRepository.getReferenceById(idUser);
    }

    @Override
    public UserResponseDTO getUser(UserLoginDTO userLoginDTO) {
        User userEntity = userRepository.findByUsernameOrEmail(userLoginDTO.username(), userLoginDTO.username());
        if(userEntity == null){
            throw new IllegalArgumentException("The user not exist.");
        }
        if(userEntity.getUsername().equals(userLoginDTO.username())
                && userEntity.getPassword().equals(userLoginDTO.password())) {
            return new UserResponseDTO(userEntity);
        }
        return null;
    }

    @Override
    public UserResponseDTO createUserToCompany(Company company) {
        User user = new User(company);

        return new UserResponseDTO(userRepository.save(user));
    }

    @Override
    public UserResponseDTO createUserToCustomer(Customer customer) {
        // TODO Auto-generated method stub
        return null;
    }

}
