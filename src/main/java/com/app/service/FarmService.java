package com.app.service;

import com.app.entity.Address;
import com.app.entity.Farm;

public interface FarmService {

    Farm addFarmToUser(Long userId, Farm farm);

    Farm getFarm(Long farmId);

    Iterable<Farm> getFarmOfUser(Long userId);

    Farm updateFarm(Long userId, Long farmId, Farm farmRequest);

    void deleteFarm(Long userId, Long farmId);

    boolean checkExistsFarm(Long farmId);

//    Farm addAddressToFarm(Long farmId, Address address);
//
//    Farm deleteAddressOfFarm(Long farmId);
}
