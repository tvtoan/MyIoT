package com.app.repository;

import com.app.entity.Fertilizer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FertilizerRepository extends CrudRepository<Fertilizer, Long> {

    Iterable<Fertilizer> findAllByNutritionCropsNutritionCropsId(Long nutritionCropsId);

    boolean existsByFertilizerIdAndNutritionCropsNutritionCropsId(Long fertilizerId, Long nutritionCropsId);
}
