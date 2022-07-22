package ru.alxstn.ContractsClient.task;

import ru.alxstn.ContractsClient.model.Contract;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static ru.alxstn.ContractsClient.util.ContractDeserializer.readContractArray;

public class FetchAllContractsTask extends ContractsTask<Contract[]> {

    public FetchAllContractsTask() {
        super("all", "GET", HttpRequest.BodyPublishers.noBody());
    }

    @Override
    Contract[] getResults(HttpResponse<String> response) {
        return readContractArray(response.body());
    }
}
