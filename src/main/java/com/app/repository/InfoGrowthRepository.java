package com.app.repository;

import com.app.entity.InfoGrowth;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoGrowthRepository extends CrudRepository<InfoGrowth, Long> {
}
