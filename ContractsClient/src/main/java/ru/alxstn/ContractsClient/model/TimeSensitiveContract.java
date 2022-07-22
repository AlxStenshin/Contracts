package ru.alxstn.ContractsClient.model;

import java.time.LocalDateTime;

import static ru.alxstn.ContractsClient.config.TimeSensitiveConst.OUTDATED_THRESHOLD_VALUE;

public class TimeSensitiveContract extends Contract {
    private final boolean outdated;


    public TimeSensitiveContract(Contract contract) {
        super(contract.getId(), contract.getCreationDate(), contract.getUpdateDate());
        this.outdated = (contract.getUpdateDate().plusDays(OUTDATED_THRESHOLD_VALUE).isBefore(LocalDateTime.now()));
    }

    public boolean isOutdated() {
        return outdated;
    }
}
