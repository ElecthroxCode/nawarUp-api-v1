package nawarup.api.controllers;

import nawarup.api.dto.UserLoginDTO;
import nawarup.api.dto.UserResponseDTO;
import nawarup.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/get")
    public ResponseEntity<UserResponseDTO> getUser(@RequestBody UserLoginDTO userLoginDTO){
        UserResponseDTO userResponseDTO = userService.getUser(userLoginDTO);
        return ResponseEntity.ok(userResponseDTO);
    }

}
