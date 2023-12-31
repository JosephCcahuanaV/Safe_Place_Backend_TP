package Backendproject.controllers;

import Backendproject.entities.Client;
import Backendproject.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "**")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.listAll();
        for(Client client: clients ){
            client.setReviews(null);
            client.setBookings(null);
        } 
        return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
    }
    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getAEmployeeById(@PathVariable("id") Long id) {
        Client client = clientService.findById(id);
        client.setBookings(null);
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
        Client newClient = clientService.save(foundClient);
        return new ResponseEntity<Client>(newClient, HttpStatus.OK);
    }




}

