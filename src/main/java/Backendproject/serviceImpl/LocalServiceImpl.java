package Backendproject.serviceImpl;

import Backendproject.dtos.CountLocalDTO;
import Backendproject.dtos.LocalDTO;
import Backendproject.dtos.LocalWithPriceIncludingIgvDto;
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

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

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

    @Override
    public CountLocalDTO countAllLocals() {
        CountLocalDTO countLocalDTO = new CountLocalDTO();
        countLocalDTO.setCantidadlocals(localRepository.countAllLocals());
        return countLocalDTO;
    }

    @Override
    public LocalDTO findLocalWithHighestPrice() {
        Local local = localRepository.findLocalWithHighestPrice();
        if (local != null) {
            return new LocalDTO(local.getId(), local.getName(), local.getPrice());
        } else {
            // Manejo de errores o retorno apropiado en caso de que no haya resultados
            return null;
        }
    }

    @Override
    public LocalWithPriceIncludingIgvDto findLocalByIdWithPriceIncludingIgv(Long id) {
        Map<String, Object> resultMap = localRepository.findLocalByIdWithPriceIncludingIgv(id);
        if (resultMap != null) {
            BigInteger localId = (BigInteger) resultMap.get("id");
            String localName = (String) resultMap.get("name");
            Double priceWithIgv = ((Number) resultMap.get("priceWithIgv")).doubleValue();

            return new LocalWithPriceIncludingIgvDto(localId.longValue(), localName, priceWithIgv);
        } else {
            // Manejo de errores o retorno apropiado en caso de que no se encuentre el local
            return null;
        }
    }




}

