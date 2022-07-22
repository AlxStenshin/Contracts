package ru.alxstn.contractsserver.service;

import org.springframework.stereotype.Service;
import ru.alxstn.contractsserver.model.Contract;
import ru.alxstn.contractsserver.repository.ContractRepository;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;

    public ContractServiceImpl(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    public Contract saveContract(Contract newContract) {
        return contractRepository.save(newContract);
    }

}
