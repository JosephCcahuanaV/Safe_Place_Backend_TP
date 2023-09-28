package Backendproject.services;


import Backendproject.dtos.LocalDTO;
import Backendproject.entities.Local;
import Backendproject.dtos.CountLocalDTO;
import java.util.List;

public interface LocalService {

    public List<Local> listAll();
    public Local save(Local local);
    public void delete(Long id);

    public Local findById(Long id);


    CountLocalDTO countAllLocals();

    LocalDTO findMostExpensiveLocal();
    Double findPriceOfWeeklyRentalById(Long localId);




}

