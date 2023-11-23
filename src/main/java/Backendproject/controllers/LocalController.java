package Backendproject.controllers;

import Backendproject.dtos.CountLocalDTO;
import Backendproject.dtos.LocalDTO;
import Backendproject.dtos.LocalWithPriceIncludingIgvDto;
import Backendproject.entities.Local;
import Backendproject.services.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "**")
public class LocalController {
    @Autowired
    LocalService localService;
    @GetMapping("/locals")
    public ResponseEntity<List<Local>> getAllLocal() {
        List<Local> locals = localService.listAll();
        for(Local local: locals){
            local.setRenter(null);

        }
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
    @DeleteMapping("/locals/delete/{id}")
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
        if (local.getPrice()!=null) {
            fountlocal.setPrice(local.getPrice());
        }

        Local newLocal = localService.save(fountlocal);
        return new ResponseEntity<Local>(newLocal, HttpStatus.OK);
    }
    @GetMapping("/countAllLocals")
    public ResponseEntity<CountLocalDTO> countAllLocals() {
        CountLocalDTO countLocalDTO = localService.countAllLocals();
        return new ResponseEntity<>(countLocalDTO, HttpStatus.OK);
    }

    @GetMapping("/highprice")
    public ResponseEntity<LocalDTO> getLocalWithHighestPrice() {
        LocalDTO dto = localService.findLocalWithHighestPrice();
        if (dto != null) {
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/igv/{id}")
    public ResponseEntity<LocalWithPriceIncludingIgvDto> getLocalWithPriceIncludingIgv(@PathVariable Long id) {
        LocalWithPriceIncludingIgvDto dto = localService.findLocalByIdWithPriceIncludingIgv(id);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}




