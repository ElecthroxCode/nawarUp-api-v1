package nawarup.api.controllers;

import nawarup.api.dto.*;
import nawarup.api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.sql.PreparedStatement;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/user/{idUser}")
    public ResponseEntity<CustomerResponseDTO> getCustomerByIdUser(@PathVariable Long idUser){
        return ResponseEntity.ok(new CustomerResponseDTO(customerService.getCustomerByIdUser(idUser)));
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> createCustomer(@RequestBody CustomerDTO customer, UriComponentsBuilder uriComponentsBuilder) {

        CustomerResponseDTO customerResponseDTO = customerService.createCustomer(customer);
        URI url = uriComponentsBuilder.path("/{id}").buildAndExpand(customerResponseDTO.id()).toUri();
        return ResponseEntity.created(url).body(customerResponseDTO);
    }

    @PutMapping
    public ResponseEntity<CustomerUpdateDTO> updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO) {

        return ResponseEntity.ok(customerService.updateCustomer(customerUpdateDTO));
    }

    @PostMapping("/topics/{idCustomer}")
    public ResponseEntity<FavoriteTopicsResponseDTO> addFavoriteTopicsToCustomer(@PathVariable Long idCustomer, @RequestBody FavoriteTopicsDTO favoriteTopicsDTO,
                                                                                 UriComponentsBuilder uriComponentsBuilder) {

        FavoriteTopicsResponseDTO favoriteTopicsResponseDTO = customerService.addFavoriteTopicsToCustomer(idCustomer, favoriteTopicsDTO);
        URI url = uriComponentsBuilder.path("/topics-customer/{id}").buildAndExpand(favoriteTopicsResponseDTO.id()).toUri();
        return ResponseEntity.created(url).body(favoriteTopicsResponseDTO);
    }

    @DeleteMapping("/idCustomer")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long idCustomer) {

        customerService.deleteCustomer(idCustomer);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/topics/remove/{idFavoriteTopics}")
    public ResponseEntity<Void> deleteFavoriteTopicsToCustomer(@PathVariable Long idFavoriteTopics) {
        customerService.deleteFavoriteTopicsToCustomer(idFavoriteTopics);
        return ResponseEntity.noContent().build();
    }


}
