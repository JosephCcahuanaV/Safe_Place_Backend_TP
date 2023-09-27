package Backendproject.serviceImpl;

import Backendproject.entities.Contract;
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
        return null;
    }

    @Override
    public Contract save(Contract contract) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Contract findById(Long id) {
        return null;
    }
}
