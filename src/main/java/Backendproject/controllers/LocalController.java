package Backendproject.controllers;

import Backendproject.entities.Client;
import Backendproject.entities.Contract;
import Backendproject.entities.Local;
import Backendproject.services.ContractService;
import Backendproject.services.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LocalController {
    @Autowired
    LocalService localService;
    @GetMapping("/locals")
    public ResponseEntity<List<Local>> getAllLocal() {
        List<Local> locals = localService.listAll();
        return new ResponseEntity<List<Local>>(locals, HttpStatus.OK);
    }
    @GetMapping("/locals/{id}")
    public ResponseEntity<Local> getALocalById(@PathVariable("id") Long id) {
        Local local = localService.findById(id);
        return new ResponseEntity<Local>(local, HttpStatus.OK);
    }
    @PostMapping("/locals/create")
    public ResponseEntity<Local> createlocal(@RequestBody Local local) {
        Local newLocal = localService.save(local);
        return new ResponseEntity<Local>(newLocal, HttpStatus.CREATED);
    }
    @DeleteMapping("/locals/{id}")
    public ResponseEntity<HttpStatus> deleteLocal(@PathVariable("id") Long id) {
        localService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/locals/update/{id}")
    public ResponseEntity<Local> updateLocal(@RequestBody Local local, @PathVariable("id") Long id) {
        Local fountlocal = localService.findById(id);
        if (local.getName()!=null) {
            fountlocal.setName(local.getName());
        }

        if (local.getUbication()!=null) {
            fountlocal.setUbication(local.getUbication());
        }
        if (local.getDescription()!=null) {
            fountlocal.setDescription(local.getDescription());
        }

        if (local.getCapacity()!=null) {
            fountlocal.setCapacity(local.getCapacity());
        }
        if (local.getPayxday()!=null) {
            fountlocal.setPayxday(local.getPayxday());
        }

        if (local.getIs_active()!=null) {
            fountlocal.setIs_active(local.getIs_active());
        }

        Local newLocal = localService.save(fountlocal);
        return new ResponseEntity<Local>(newLocal, HttpStatus.OK);
    }

}




