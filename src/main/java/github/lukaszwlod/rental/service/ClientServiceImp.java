package github.lukaszwlod.rental.service;

import github.lukaszwlod.rental.model.Client;
import github.lukaszwlod.rental.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImp  implements ClientService{


    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImp(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getClients() {
       return clientRepository.findAll();
    }

    @Override
    public void saveClient(Client client) {
    clientRepository.save(client);

    }



    @Override
    public void deleteClientById(Long id) {
       clientRepository.deleteById(id);
    }

    @Override
    public void update(Client client) {
       clientRepository.save(client);
    }

    @Override
    public Optional<Client> getOne(Long id) {
        return clientRepository.findById(id);
    }


}