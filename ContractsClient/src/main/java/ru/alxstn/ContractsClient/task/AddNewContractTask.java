package ru.alxstn.ContractsClient.task;

import ru.alxstn.ContractsClient.model.Contract;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static ru.alxstn.ContractsClient.util.ContractDeserializer.readContract;

public class AddNewContractTask extends ContractsTask<Contract> {

    public AddNewContractTask() {
        super("new", "POST", HttpRequest.BodyPublishers.noBody());
    }

    @Override
    Contract getResults(HttpResponse<String> response) {
        return readContract(response.body());
    }
}
