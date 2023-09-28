package Backendproject.controllers;

import Backendproject.dtos.CountClientDTO;
import Backendproject.entities.Client;
import Backendproject.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class ClientController {

    @Autowired
    ClientService clientService;

    //NUEVA RUTA : http://localhost:8080/api/clients

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.listAll();
        return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
    }
    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getAEmployeeById(@PathVariable("id") Long id) {
        Client client = clientService.findById(id);
        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }

    @PostMapping("/clients/create")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client newClient = clientService.save(client);
        return new ResponseEntity<Client>(newClient, HttpStatus.CREATED);
    }
    @DeleteMapping("/clients/delete/{id}")
    public ResponseEntity<HttpStatus> deleteClient(@PathVariable("id") Long id) {
        clientService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/clients/update/{id}")
    public ResponseEntity<Client> updateClient(@RequestBody Client client, @PathVariable("id") Long id) {
        Client foundClient = clientService.findById(id);
        if (client.getName()!=null) {
            foundClient.setName(client.getName());
        }
        if (client.getLastname()!=null) {
            foundClient.setLastname(client.getLastname());
        }
        if (client.getNumberPhone()!=null) {
            foundClient.setNumberPhone(client.getNumberPhone());
        }
        if (client.getDni()!=null) {
            foundClient.setDni(client.getDni());
        }

        if (client.getRuc()!=null) {
            foundClient.setRuc(client.getRuc());
        }


        Client newClient = clientService.save(foundClient);
        return new ResponseEntity<Client>(newClient, HttpStatus.OK);
    }


    @GetMapping("/contarPorNacionalidad")
    public ResponseEntity<List<CountClientDTO>> countClientsByNationality() {
        List<CountClientDTO> counts = clientService.countClientsByNationality();
        return new ResponseEntity<>(counts, HttpStatus.OK);
    }


}

