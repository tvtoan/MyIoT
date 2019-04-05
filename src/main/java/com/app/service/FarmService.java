package com.app.service;

import com.app.entity.Address;
import com.app.entity.Farm;

public interface FarmService {
    // Relationship
    String addFarmToUser(Long userId, Farm farm);

    String getFarmOfUser(Long userId);

    String updateFarm(Long userId, Long farmId, Farm farmRequest);

    String deleteFarm(Long userId, Long farmId);

    boolean checkExistsFarm(Long farmId);

    Farm getFarm(Long farmId);

    Iterable<Farm> getFarms();

    Farm saveOrUpdateFarm(Farm farm);

    void deleteFarm(Long farmId);

//    Farm addAddressToFarm(Long farmId, Address address);
//
//    Farm deleteAddressOfFarm(Long farmId);
    String save(Farm farm);
}
