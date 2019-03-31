package com.app.repository;

import com.app.entity.NutritionCrops;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NutritionCropsRepository extends CrudRepository<NutritionCrops, Long> {

    Iterable<NutritionCrops> findAllByCropsCropsId(Long cropId);

    boolean existsByNutritionCropsIdAndCropsCropsId(Long nutritionCropsId, Long cropsId);
}
