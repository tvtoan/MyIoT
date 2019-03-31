package com.app.service;

import com.app.entity.NutritionCrops;

public interface NutritionCropsService {

    NutritionCrops addNutritionCrops(Long cropsId, NutritionCrops nutritionCrops);

    Iterable<NutritionCrops> getNutritionCropsOfCrops(Long cropsId);

    NutritionCrops updateNutritionCropsOfCrops(Long cropsId, Long nutritionCropsId, NutritionCrops nutritionCropsRequest);

    void deleteNutritionCrops(Long nutritionCropsId);
}
