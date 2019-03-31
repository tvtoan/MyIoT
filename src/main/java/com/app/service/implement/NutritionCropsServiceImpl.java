package com.app.service.implement;

import com.app.entity.Crops;
import com.app.entity.NutritionCrops;
import com.app.repository.CropsRepository;
import com.app.repository.NutritionCropsRepository;
import com.app.service.NutritionCropsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NutritionCropsServiceImpl implements NutritionCropsService {

    @Autowired
    private NutritionCropsRepository nutritionCropsRepository;

    @Autowired
    private CropsRepository cropsRepository;

    @Override
    public NutritionCrops addNutritionCrops(Long cropsId, NutritionCrops nutritionCrops) {
        Crops c = cropsRepository.findById(cropsId).get();
        nutritionCrops.setCrops(c);
        return nutritionCropsRepository.save(nutritionCrops);
    }

    @Override
    public Iterable<NutritionCrops> getNutritionCropsOfCrops(Long cropsId) {
        return nutritionCropsRepository.findAllByCropsCropsId(cropsId);
    }

    @Override
    public NutritionCrops updateNutritionCropsOfCrops(Long cropsId, Long nutritionCropsId, NutritionCrops nutritionCropsRequest) {
        if (!nutritionCropsRepository.existsByNutritionCropsIdAndCropsCropsId(nutritionCropsId, cropsId)) {
            System.out.println("NutritionCrops no exist.");
            return null;
        }
        NutritionCrops nutri = nutritionCropsRepository.findById(nutritionCropsId).get();
        nutri.setDate(nutritionCropsRequest.getDate());
        System.out.println("Update NutritionCrops done.");
        return nutritionCropsRepository.save(nutri);
    }

    @Override
    public void deleteNutritionCrops(Long nutritionCropsId) {
        nutritionCropsRepository.deleteById(nutritionCropsId);
        System.out.println("Delete NutritionCrops done.");
    }
}
