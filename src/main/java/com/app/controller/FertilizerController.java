package com.app.controller;

import com.app.entity.Fertilizer;
import com.app.service.FertilizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FertilizerController {

    @Autowired
    private FertilizerService fertilizerService;

    @GetMapping("/{nutritionCropsId}/add-fertilizer")
    public Fertilizer addFertilizer(@PathVariable Long nutritionCropsId) {
        return fertilizerService.addFertilizer(nutritionCropsId, new Fertilizer("Fertilizer description 1"));
    }

    @GetMapping("/{nutritionCropsId}/update-fertilizer/{fertilizerId}")
    public Fertilizer updateNutritionCrops(@PathVariable Long nutritionCropsId, @PathVariable Long fertilizerId) {
        return fertilizerService.updateFertilizer(nutritionCropsId, fertilizerId, new Fertilizer("Fertilizer description 1 update"));
    }

    @GetMapping("/{nutritionCropsId}/get-fertilizer")
    public Iterable<Fertilizer> getFertilizerOfNutritionCrops(@PathVariable Long nutritionCropsId) {
        return fertilizerService.getFertilizerOfNutritionCrops(nutritionCropsId);
    }

    @GetMapping("/{nutritionCropsId}/delete-fertilizer/{fertilizerId}")
    public void deleteNutritionCrops(@PathVariable Long nutritionCropsId, @PathVariable Long fertilizerId) {
        fertilizerService.deleteFertilizer(fertilizerId);
    }
}
