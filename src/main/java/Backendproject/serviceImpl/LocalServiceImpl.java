package Backendproject.serviceImpl;

import Backendproject.entities.Local;
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
        return null;
    }

    @Override
    public Local save(Local local) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
