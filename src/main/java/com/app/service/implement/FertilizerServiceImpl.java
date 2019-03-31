package com.app.service.implement;

import com.app.entity.Crops;
import com.app.entity.Fertilizer;
import com.app.entity.NutritionCrops;
import com.app.repository.FertilizerRepository;
import com.app.repository.NutritionCropsRepository;
import com.app.service.FertilizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FertilizerServiceImpl implements FertilizerService {

    @Autowired
    private FertilizerRepository fertilizerRepository;

    @Autowired
    private NutritionCropsRepository nutritionCropsRepository;

    @Override
    public Fertilizer addFertilizer(Long nutritionCropsId, Fertilizer fertilizer) {
        NutritionCrops nutri = nutritionCropsRepository.findById(nutritionCropsId).get();
        fertilizer.setNutritionCrops(nutri);
        return fertilizerRepository.save(fertilizer);
    }

    @Override
    public Iterable<Fertilizer> getFertilizerOfNutritionCrops(Long nutritionCropsId) {
        return fertilizerRepository.findAllByNutritionCropsNutritionCropsId(nutritionCropsId);
    }

    @Override
    public Fertilizer getFertilizer(Long fertilizerId) {
        return fertilizerRepository.findById(fertilizerId).get();
    }

    @Override
    public Fertilizer updateFertilizer(Long nutritionCropsId, Long fertilizerId, Fertilizer fertilizerRequest) {
        if (!fertilizerRepository.existsByFertilizerIdAndNutritionCropsNutritionCropsId(fertilizerId, nutritionCropsId)) {
            System.out.println("Fertilizer no exist.");
            return null;
        }
        Fertilizer fer = fertilizerRepository.findById(fertilizerId).get();
        fer.setDescription(fertilizerRequest.getDescription());
        System.out.println("Update Fertilizer done.");
        return fertilizerRepository.save(fer);
    }

    @Override
    public void deleteFertilizer(Long fertilizerId) {
        fertilizerRepository.deleteById(fertilizerId);
        System.out.println("Delete Fertilizer done.");
    }
}
