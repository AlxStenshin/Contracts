package ru.alxstn.ContractsClient.view;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import ru.alxstn.ContractsClient.exception.DataRequestException;
import ru.alxstn.ContractsClient.task.AddNewContractTask;
import ru.alxstn.ContractsClient.task.AddNewOutdatedContract;
import ru.alxstn.ContractsClient.task.FetchAllContractsTask;
import ru.alxstn.ContractsClient.model.Contract;
import ru.alxstn.ContractsClient.model.TimeSensitiveContract;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrimaryController {

    @FXML
    private VBox dataContainer;
    @FXML
    private TableView<TimeSensitiveContract> tableView;
    @FXML
    public Label statusLabel;

    @FXML
    private void initialize() {
        Thread.setDefaultUncaughtExceptionHandler(this::showError);

        tableView = new TableView<>();
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn id = new TableColumn("ID");
        id.setCellValueFactory(new PropertyValueFactory<TimeSensitiveContract, Long>("id"));

        TableColumn created = new TableColumn("CREATED");
        created.setCellValueFactory(new PropertyValueFactory<TimeSensitiveContract, LocalDateTime>("creationDate"));

        TableColumn updated = new TableColumn("UPDATED");
        updated.setCellValueFactory(new PropertyValueFactory<TimeSensitiveContract, LocalDateTime>("updateDate"));

        TableColumn outdated = new TableColumn("OUTDATED");
        outdated.setCellValueFactory(new PropertyValueFactory<TimeSensitiveContract, Boolean>("outdated"));

        Callback<TableColumn<TimeSensitiveContract, Boolean>, TableCell<TimeSensitiveContract, Boolean>> booleanCellFactory =
                p -> new CheckBoxCell();
        outdated.setCellFactory(booleanCellFactory);

        tableView.getColumns().addAll(id, created, updated, outdated);
        dataContainer.getChildren().add(tableView);
    }

    private void showError(Thread t, Throwable e) {
        System.err.println(e.getMessage());
        updateStatus(e.getMessage());
    }

    @FXML
    private void requestContracts() {
        try {
            FetchAllContractsTask task = new FetchAllContractsTask();
            task.setOnSucceeded(e -> showContracts(task.getValue()));
            new Thread(task).start();
        } catch (DataRequestException e) {
            updateStatus(e.getMessage());
        }
    }

    @FXML
    public void addNewContract() {
        try {
            AddNewContractTask task = new AddNewContractTask();
            task.setOnSucceeded(e -> updateStatus("Contract added."));
            new Thread(task).start();
        } catch (DataRequestException e) {
            updateStatus(e.getMessage());
        }
    }

    @FXML
    public void addNewOutdatedContract() {
        try {
            AddNewOutdatedContract task = new AddNewOutdatedContract();
            task.setOnSucceeded(e -> updateStatus("Outdated Contract added."));
            new Thread(task).start();
        } catch (DataRequestException e) {
            updateStatus(e.getMessage());
        }
    }

    private void updateStatus(String status) {
        System.out.println(status);
        statusLabel.setText("Status: " + status);
    }

    private void showContracts(Contract[] list) {
        List<TimeSensitiveContract> results = Arrays.stream(list)
                .map(TimeSensitiveContract::new)
                .collect(Collectors.toList());

        tableView.getItems().clear();
        tableView.setItems(FXCollections.observableArrayList(results));
        statusLabel.setText("Status: " + results.size() + " Contracts Received.");
    }
}
