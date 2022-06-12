package github.lukaszwlod.rental.service;

import github.lukaszwlod.rental.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ClientService {
    List<Client> getClients();
    void saveClient(Client client);
    void deleteClientById(Long id);
    void update (Client client);


    Client getOne(Long id);

}
