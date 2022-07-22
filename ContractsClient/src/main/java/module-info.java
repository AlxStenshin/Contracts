module ru.alxstn.ContractsClient {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires gson;
    
    opens ru.alxstn.ContractsClient;
    exports ru.alxstn.ContractsClient;
    exports ru.alxstn.ContractsClient.model;
    opens ru.alxstn.ContractsClient.model;
    exports ru.alxstn.ContractsClient.view;
    opens ru.alxstn.ContractsClient.view;
    exports ru.alxstn.ContractsClient.task;
    opens ru.alxstn.ContractsClient.task;
    exports ru.alxstn.ContractsClient.exception;
    opens ru.alxstn.ContractsClient.exception;
    exports ru.alxstn.ContractsClient.util;
    opens ru.alxstn.ContractsClient.util;
}
