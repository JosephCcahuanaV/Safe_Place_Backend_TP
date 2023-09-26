package Backendproject.services;

import Backendproject.entities.Client;
import Backendproject.entities.Contract;

import java.util.List;

public interface ContractService {

    public List<Contract> listAll();
    public Contract save(Contract contract);
    public void delete(Long id);
    public Contract findById(Long id);


}
