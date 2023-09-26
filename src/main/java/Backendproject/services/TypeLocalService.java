package Backendproject.services;

import Backendproject.entities.Rol;
import Backendproject.entities.TypeLocal;

import java.util.List;

public interface TypeLocalService {

    public List<TypeLocal> listAll();
    public TypeLocal save(TypeLocal typeLocal);
    public void delete(Long id);
}
