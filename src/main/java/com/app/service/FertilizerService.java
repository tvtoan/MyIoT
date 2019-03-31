package com.app.service;

import com.app.entity.Fertilizer;

public interface FertilizerService {

    Fertilizer addFertilizer(Long nutritionCropsId, Fertilizer fertilizer);

    Iterable<Fertilizer> getFertilizerOfNutritionCrops(Long nutritionCropsId);

    Fertilizer getFertilizer(Long fertilizerId);

    Fertilizer updateFertilizer(Long nutritionCropsId, Long fertilizerId, Fertilizer fertilizerRequest);

    void deleteFertilizer(Long fertilizerId);
}
