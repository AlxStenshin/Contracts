package ru.alxstn.ContractsClient.view;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import ru.alxstn.ContractsClient.model.TimeSensitiveContract;;

public class CheckBoxCell extends TableCell<TimeSensitiveContract, Boolean> {

    private final CheckBox checkBox;

    public CheckBoxCell() {
        checkBox = new CheckBox();
        checkBox.setDisable(true);
        checkBox.setAlignment(Pos.CENTER);
        checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (isEditing())
                commitEdit(newValue != null && newValue);
        });

        this.setAlignment(Pos.CENTER);
        this.setGraphic(checkBox);
        this.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        this.setEditable(true);
    }

    @Override
    public void startEdit() {
        super.startEdit();
        if (isEmpty()) {
            return;
        }
        checkBox.setDisable(false);
        checkBox.requestFocus();
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();
        checkBox.setDisable(true);
    }

    public void commitEdit(Boolean value) {
        super.commitEdit(value);
        checkBox.setDisable(true);
    }

    @Override
    public void updateItem(Boolean item, boolean empty) {
        super.updateItem(item, empty);
        if (!isEmpty()) {
            checkBox.setSelected(item);
        }
    }
}