package Backendproject.serviceImpl;

import Backendproject.entities.Client;
import Backendproject.entities.Contract;
import Backendproject.exceptions.ResourceNotFoundException;
import Backendproject.repositories.ContractRepository;
import Backendproject.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    ContractRepository contractRepository;
    @Override
    public List<Contract> listAll() {
        List<Contract> contracts = contractRepository.findAll();
        return contracts;
    }

    @Override
    public Contract save(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public void delete(Long id) {
        Contract contract = findById(id);
        contractRepository.delete(contract);
    }

    @Override
    public Contract findById(Long id) {
        Contract contractFound = contractRepository.findById(id).orElse(null);
        if (contractFound == null) {
            throw new ResourceNotFoundException("There are no object with the id: "+String.valueOf(id));
        }

        return contractFound;
    }
}
