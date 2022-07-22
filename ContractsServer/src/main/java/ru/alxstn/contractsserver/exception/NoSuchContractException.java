package ru.alxstn.contractsserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Contract not found")
public class NoSuchContractException extends RuntimeException {
    public NoSuchContractException() {
        super();
    }
}
