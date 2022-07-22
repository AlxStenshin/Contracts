package ru.alxstn.contractsserver.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.alxstn.contractsserver.model.Contract;
import ru.alxstn.contractsserver.repository.ContractRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ContractServiceTest {

    @Mock
    private ContractRepository repository;

    @InjectMocks
    private ContractServiceImpl service;

    @Test
    void shouldCallRepositoryOnSave() {
        final Contract contract = mock(Contract.class);
        service.saveContract(contract);
        verify(repository).save(contract);
    }

    @Test
    void shouldCallRepositoryOnFindAll() {
        final Contract contract = mock(Contract.class);
        List<Contract> expectedContracts = List.of(contract);
        when(repository.findAll()).thenReturn(expectedContracts);

        final List<Contract> actualContracts = service.findAll();

        assertNotNull(actualContracts);
        assertEquals(expectedContracts, actualContracts);
        verify(repository).findAll();
    }
}
