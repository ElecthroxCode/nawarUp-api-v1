package nawarup.api.service;

import nawarup.api.dto.*;
import nawarup.api.models.Customer;

public interface CustomerService {
    public CustomerResponseDTO createCustomer(CustomerDTO customerDTO);

    public CustomerUpdateDTO updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    public void permanentDeleteCustomer(Long idCustomer);

    public Customer getCustomer(Long idCustomer);

    public Customer getCustomerByIdUser(Long idUser);

    public void deleteCustomer(Long idCustomer);

    public FavoriteTopicsResponseDTO addFavoriteTopicsToCustomer(Long idCustomer, FavoriteTopicsDTO favoriteTopicsDTO);

    void deleteFavoriteTopicsToCustomer(Long idFavoriteTopics);
}
