package com.app.repository;

import com.app.entity.TransactionFarm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionFarmRepository extends CrudRepository<TransactionFarm, Long> {
}
