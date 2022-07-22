package ru.alxstn.ContractsClient;

import org.junit.jupiter.api.Test;
import ru.alxstn.ContractsClient.exception.OutOfDataException;
import ru.alxstn.ContractsClient.model.Contract;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.alxstn.ContractsClient.util.ContractDeserializer.readContractArray;

class FetchContractsTaskTest {

    @Test
    public void shouldReadTwoContracts() {

        String json = "[" +
                "{\"id\":47,\"creationDate\":\"2022-07-19T09:02:28.007\",\"updateDate\":\"2022-07-19T09:02:28.007\"}," +
                "{\"id\":48,\"creationDate\":\"2022-07-19T09:08:18.909\",\"updateDate\":\"2022-07-19T09:08:18.909\"}" +
                "]";

        Contract[] contracts = readContractArray(json);
        assertEquals(2, contracts.length);
    }

    @Test
    public void shouldThrowNoDataException(){
        String json = "[]";
        assertThrows(OutOfDataException.class, () -> readContractArray(json));
    }
}