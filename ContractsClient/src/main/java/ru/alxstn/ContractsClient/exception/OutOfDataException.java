package ru.alxstn.ContractsClient.exception;

public class OutOfDataException extends RuntimeException {
    public OutOfDataException() {
        super("Nothing found");
    }
}
