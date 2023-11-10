package Backendproject.serviceImpl;

import Backendproject.dtos.ClientDTO;
import Backendproject.dtos.CountClientDTO;
import Backendproject.entities.Client;
import Backendproject.exceptions.IncompleteDataException;
import Backendproject.exceptions.KeyRepeatedDataException;
import Backendproject.exceptions.ResourceNotFoundException;
import Backendproject.repositories.ClientRepository;
import Backendproject.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        if (client.getName()==null || client.getName().isEmpty()) {
            throw new IncompleteDataException("name can not be null or empty");
        }

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
        if (clientFound == null) {
            throw new ResourceNotFoundException("There are no object with the id: "+String.valueOf(id));
        }

        return clientFound;
    }

    @Override
    public Client findOldestClient() {
        return clientRepository.findOldestClient();
    }

    public List<CountClientDTO> countClientsByNationality() {
        List<Object[]> results = clientRepository.countClientsByNationality();

        return results.stream()
                .map(result -> new CountClientDTO((String) result[0], (Long) result[1]))
                .collect(Collectors.toList());
    }

}
