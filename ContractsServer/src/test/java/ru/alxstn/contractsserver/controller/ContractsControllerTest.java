package ru.alxstn.contractsserver.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.alxstn.contractsserver.model.Contract;
import ru.alxstn.contractsserver.service.ContractServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ContractsControllerTest {

    @Mock
    private ContractServiceImpl contractService;

    @InjectMocks
    private ContractsController contractsController;

    @Test
    public void shouldSaveNewContract() {
        final Contract contract = mock(Contract.class);
        contractsController.saveContract(java.util.Optional.ofNullable(contract));
        verify(contractService).saveContract(contract);
    }

    @Test
    public void shouldReturnSavedContract() {
        final Contract contract = mock(Contract.class);
        List<Contract> expectedContracts = List.of(contract);
        when(contractService.findAll()).thenReturn(expectedContracts);

        List<Contract> actualContracts = contractsController.getAll().getBody();

        assertNotNull(actualContracts);
        assertEquals(expectedContracts, actualContracts);
        verify(contractService).findAll();
    }
}