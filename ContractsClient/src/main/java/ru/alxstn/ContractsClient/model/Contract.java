package ru.alxstn.ContractsClient.model;

import java.time.LocalDateTime;

public class Contract {

    private long id;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

    public Contract() {
    }

    public Contract(LocalDateTime creationDate, LocalDateTime updateDate) {
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public Contract(long id, LocalDateTime creationDate, LocalDateTime updateDate) {
        this.id = id;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
