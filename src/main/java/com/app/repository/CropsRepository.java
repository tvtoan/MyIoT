package com.app.repository;

import com.app.entity.Crops;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropsRepository extends CrudRepository<Crops, Long> {
}
