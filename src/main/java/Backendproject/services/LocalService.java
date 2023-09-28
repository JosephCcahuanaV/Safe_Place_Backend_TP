package Backendproject.services;


import Backendproject.entities.Local;

import java.util.List;

public interface LocalService {

    public List<Local> listAll();
    public Local save(Local local);
    public void delete(Long id);

    public Local findById(Long id);


}

