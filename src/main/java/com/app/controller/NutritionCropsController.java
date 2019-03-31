package com.app.controller;

import com.app.entity.NutritionCrops;
import com.app.service.NutritionCropsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class NutritionCropsController {

    @Autowired
    private NutritionCropsService nutritionCropsService;

    @GetMapping("/{cropsId}/add-nutrition")
    public NutritionCrops addNutritionCrops(@PathVariable Long cropsId) {
        return nutritionCropsService.addNutritionCrops(cropsId, new NutritionCrops(new Date()));
    }

    @GetMapping("/{cropsId}/update-nutrition/{nutritionCropsId}")
    public NutritionCrops updateNutritionCrops(@PathVariable Long cropsId, @PathVariable Long nutritionCropsId) {
        return nutritionCropsService.updateNutritionCropsOfCrops(cropsId, nutritionCropsId, new NutritionCrops(new Date()));
    }

    @GetMapping("/{cropsId}/get-nutrition")
    public Iterable<NutritionCrops> getNutritionCropsOfCrops(@PathVariable Long cropsId) {
        return nutritionCropsService.getNutritionCropsOfCrops(cropsId);
    }

    @GetMapping("/{cropsId}/delete-nutrition/{nutritionCropsId}")
    public void deleteNutritionCrops(@PathVariable Long cropsId, @PathVariable Long nutritionCropsId) {
        nutritionCropsService.deleteNutritionCrops(cropsId);
    }
}
