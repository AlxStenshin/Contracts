package ru.alxstn.contractsserver.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.alxstn.contractsserver.model.Contract;

import java.util.List;

@Repository
public interface ContractRepository extends CrudRepository<Contract, Long> {

    // Using Query Methods
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
    @Transactional(readOnly = true)
    List<Contract> findAll();
}
