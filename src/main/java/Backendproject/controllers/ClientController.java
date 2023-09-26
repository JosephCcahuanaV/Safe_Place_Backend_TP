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

public class ClientController {

    @Autowired
    ClientService clientService;

    //NUEVA RUTA : http://localhost:8080/api/clients

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.listAll();
        return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
    }

    @PostMapping("/clients")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client newClient = clientService.save(client);
        return new ResponseEntity<Client>(newClient, HttpStatus.CREATED);
    }
    @DeleteMapping("/clients/{id}")
    public ResponseEntity<HttpStatus> deleteClient(@PathVariable("id") Long id) {
        clientService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
