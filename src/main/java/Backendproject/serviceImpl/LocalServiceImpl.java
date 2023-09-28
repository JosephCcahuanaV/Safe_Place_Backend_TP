package Backendproject.serviceImpl;

import Backendproject.entities.Client;
import Backendproject.entities.Local;
import Backendproject.entities.Payment;
import Backendproject.exceptions.IncompleteDataException;
import Backendproject.exceptions.KeyRepeatedDataException;
import Backendproject.exceptions.ResourceNotFoundException;
import Backendproject.repositories.LocalRepository;
import Backendproject.services.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalServiceImpl implements LocalService {

    @Autowired
    LocalRepository localRepository;
    @Override
    public List<Local> listAll() {
        List<Local> locals = localRepository.findAll();
        return locals;
    }

    @Override
    public Local save(Local local) {

        if (local.getName()==null || local.getName().isEmpty()) {
            throw new IncompleteDataException("name can not be null or empty");
        }

        return localRepository.save(local);
    }

    @Override
    public void delete(Long id) {
        Local local = findById(id);
        localRepository.delete(local);
    }
    @Override
    public Local findById(Long id) {
        Local localFound = localRepository.findById(id).orElse(null);
        if (localFound == null) {
            throw new ResourceNotFoundException("There are no object with the id: "+String.valueOf(id));
        }
        return localFound;
    }
}

