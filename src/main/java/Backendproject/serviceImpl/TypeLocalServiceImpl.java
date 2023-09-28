package Backendproject.serviceImpl;

import Backendproject.entities.Rol;
import Backendproject.entities.TypeLocal;
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
        List<TypeLocal> typeLocals=typeLocalRepository.findAll();
        return typeLocals;
    }

    @Override
    public TypeLocal save(TypeLocal typeLocal) {
        return typeLocalRepository.save(typeLocal);
    }

    @Override
    public void delete(Long id){
        TypeLocal typeLocal=findById(id);
        typeLocalRepository.delete(typeLocal);
    }

    @Override
    public TypeLocal findById(Long id){
        TypeLocal typeLocalFound = typeLocalRepository.findById(id).orElse(null);
        return typeLocalFound;
    }

}
