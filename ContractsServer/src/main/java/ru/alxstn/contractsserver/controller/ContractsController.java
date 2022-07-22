package ru.alxstn.contractsserver.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alxstn.contractsserver.model.Contract;
import ru.alxstn.contractsserver.service.ContractService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/contracts/v1/", produces = MediaType.APPLICATION_JSON_VALUE)
public class ContractsController {

    private final ContractService contractService;

    public ContractsController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Contract>> getAll() {
        final List<Contract> result = contractService.findAll();
        return ResponseEntity.ok(result);
    }

    @PostMapping("/new")
    public Contract saveContract(@RequestBody(required=false) Optional<Contract> contract) {
        return contractService.saveContract(contract.orElseGet(Contract::new));
    }
}
