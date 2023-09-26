package Backendproject.serviceImpl;

import Backendproject.entities.TypeLocal;
import Backendproject.repositories.ContractRepository;
import Backendproject.repositories.TypeLocalRepository;
import Backendproject.services.TypeLocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TypeLocalServiceImpl implements TypeLocalService {

    @Autowired
    TypeLocalRepository typeLocalRepository;
    @Override
    public List<TypeLocal> listAll() {
        return null;
    }

    @Override
    public TypeLocal save(TypeLocal typeLocal) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
