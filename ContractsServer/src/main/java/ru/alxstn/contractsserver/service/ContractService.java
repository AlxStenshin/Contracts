package ru.alxstn.contractsserver.service;

import ru.alxstn.contractsserver.model.Contract;

import java.util.List;

public interface ContractService {

    List<Contract> findAll();
    Contract saveContract(Contract contract);
}
