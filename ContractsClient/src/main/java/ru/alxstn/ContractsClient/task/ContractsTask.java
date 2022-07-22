package ru.alxstn.ContractsClient.task;

import javafx.concurrent.Task;
import ru.alxstn.ContractsClient.exception.DataRequestException;
import ru.alxstn.ContractsClient.exception.OutOfDataException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public abstract class ContractsTask<T> extends Task<T> {
    private static final String CONTRACTS_API_URL = "http://localhost:8080/api/contracts/v1/";
    private final String endpoint;
    private final String httpMethod;
    private final HttpRequest.BodyPublisher bodyPublisher;

    public ContractsTask(String endpoint, String httpMethod, HttpRequest.BodyPublisher bodyPublisher) {
        this.endpoint = endpoint;
        this.httpMethod = httpMethod;
        this.bodyPublisher = bodyPublisher;
    }

    @Override
    protected T call() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(CONTRACTS_API_URL + endpoint))
                .header("Content-Type", "application/json")
                .method(httpMethod, bodyPublisher)
                .build();

        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new DataRequestException("HTTP Request Error Code: " + response.statusCode());
            }
            return getResults(response);
        } catch (IOException | InterruptedException | DataRequestException | OutOfDataException e) {
            throw new DataRequestException(e.getMessage());
        }
    }

    @Override
    protected void failed() {
        super.failed();
        throw new DataRequestException(getException().getMessage());
    }

    abstract T getResults(HttpResponse<String> response);
}
