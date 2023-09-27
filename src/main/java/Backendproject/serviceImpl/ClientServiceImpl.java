package Backendproject.serviceImpl;

import Backendproject.entities.Client;
import Backendproject.repositories.ClientRepository;
import Backendproject.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;
    @Override
    public List<Client> listAll() {
        List<Client> clients = clientRepository.findAll();
        return clients;
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void delete(Long id) {

        Client client = findById(id);
        clientRepository.delete(client);

    }

    @Override
    public Client findById(Long id) {
        Client clientFound = clientRepository.findById(id).orElse(null);

        return clientFound;
    }
}
