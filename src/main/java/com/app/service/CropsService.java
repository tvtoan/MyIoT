package com.app.service;

import com.app.entity.Crops;

public interface CropsService {

    Crops addCrops(Crops crops);

    Iterable<Crops> getAllCrops();

    Crops getCrops(Long cropsId);

    Crops updateCrops(Long cropsId, Crops cropsRequest);

    void deleteCrops(Long cropsId);
}
