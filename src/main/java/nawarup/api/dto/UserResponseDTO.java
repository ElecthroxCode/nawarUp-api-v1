package nawarup.api.dto;

import nawarup.api.models.User;
import nawarup.api.models.UserType;

public record UserResponseDTO(
        Long id,
        String username,
        String password,
        String email,
        UserType userType

) {

    public UserResponseDTO(User user) {
        this(user.getId(), user.getUsername(), user.getPassword(), user.getEmail(), user.getUserType());
    }

}
