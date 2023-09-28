package Backendproject.services;

import Backendproject.dtos.ClientDTO;
import Backendproject.dtos.CountClientDTO;
import Backendproject.entities.Client;

import java.util.List;

public interface ClientService {


    public List<Client> listAll();
    public Client save(Client client);
    public void delete(Long id);

    public Client findById(Long id);
    Client findOldestClient();

    List<ClientDTO> countClientsByRuc();

}
