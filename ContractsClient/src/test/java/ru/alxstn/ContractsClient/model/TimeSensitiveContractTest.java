package ru.alxstn.ContractsClient.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TimeSensitiveContractTest {

    @Test
    public void shouldBeOutdated() {
        Contract outdatedContract = new Contract(0, LocalDateTime.MIN, LocalDateTime.MIN);
        TimeSensitiveContract tsContract = new TimeSensitiveContract(outdatedContract);
        assertTrue(tsContract.isOutdated());
    }

    @Test
    public void shouldNotBeOutdated() {
        Contract contract = new Contract(0, LocalDateTime.MIN, LocalDateTime.now());
        TimeSensitiveContract tsContract = new TimeSensitiveContract(contract);
        assertFalse(tsContract.isOutdated());
    }

}