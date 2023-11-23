package Backendproject.controllers;

import Backendproject.entities.TypeLocal;
import Backendproject.services.TypeLocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "**")
public class TypeLocalController {
    @Autowired
    TypeLocalService typeLocalService;

    @GetMapping("/typelocals")
    public ResponseEntity<List<TypeLocal>> getAllTypeLocals() {
        List<TypeLocal> typeLocals = typeLocalService.listAll();
        return new ResponseEntity<List<TypeLocal>>(typeLocals, HttpStatus.OK);
    }

    @PostMapping("/typelocals/create")
    public ResponseEntity<TypeLocal> createTypeLocal(@RequestBody TypeLocal typeLocal) {
        TypeLocal newTypeLocal = typeLocalService.save(typeLocal);
        return new ResponseEntity<TypeLocal>(newTypeLocal, HttpStatus.CREATED);
    }
    @DeleteMapping("/typelocals/delete/{id}")
    public ResponseEntity<HttpStatus> deleteTypeLocal(@PathVariable("id") Long id) {
        typeLocalService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
