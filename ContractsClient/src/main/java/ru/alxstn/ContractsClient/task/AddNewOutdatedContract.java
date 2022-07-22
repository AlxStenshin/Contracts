package ru.alxstn.ContractsClient.task;


import ru.alxstn.ContractsClient.model.Contract;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import static ru.alxstn.ContractsClient.util.ContractDeserializer.gson;

import static ru.alxstn.ContractsClient.config.TimeSensitiveConst.OUTDATED_THRESHOLD_VALUE;
import static ru.alxstn.ContractsClient.util.ContractDeserializer.readContract;

public class AddNewOutdatedContract extends ContractsTask<Contract> {

    public AddNewOutdatedContract() {
        super("new", "POST", HttpRequest.BodyPublishers.ofString(buildOutdatedContractJson()));
    }

    private static String buildOutdatedContractJson(){
        LocalDateTime date = LocalDateTime.now().minusDays(OUTDATED_THRESHOLD_VALUE);
        Contract outdated = new Contract(date, date);
        String json = gson.toJson(outdated);
        return json;
    }

    @Override
    Contract getResults(HttpResponse<String> response) {
        return readContract(response.body());
    }
}
