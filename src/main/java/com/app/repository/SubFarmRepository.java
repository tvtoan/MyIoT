package com.app.repository;

import com.app.entity.SubFarm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubFarmRepository extends CrudRepository<SubFarm, Long> {
}
