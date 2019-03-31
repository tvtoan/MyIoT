package com.app.controller;

import com.app.entity.Address;
import com.app.entity.Farm;
import com.app.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FarmController {

    @Autowired
    private FarmService farmService;

    @GetMapping("/{userId}/add-farm")
    public Farm addFarm(@PathVariable Long userId) {
        return farmService.addFarmToUser(userId, new Farm("Farm 1", new Address()));
    }

    @GetMapping("/{userId}/get-farm/{farmId}")
    public Farm getFarm(@PathVariable Long userId, @PathVariable Long farmId) {
        return farmService.getFarm(farmId);
    }

    @GetMapping("/{userId}/all-farms")
    public Iterable<Farm> getFarmOfUser(@PathVariable Long userId) {
        return farmService.getFarmOfUser(userId);
    }

    @GetMapping("/{userId}/delete-farm/{farmId}")
    public void deleteFarm(@PathVariable Long userId, @PathVariable Long farmId) {
        farmService.deleteFarm(userId, farmId);
    }

    @GetMapping("/check/{farmId}")
    public boolean checkFarm(@PathVariable Long farmId) {
        return farmService.checkExistsFarm(farmId);
    }

    @GetMapping("/{userId}/update-farm/{farmId}")
    public Farm updateFarm(@PathVariable Long userId, @PathVariable Long farmId) {
        return farmService.updateFarm(userId, farmId, new Farm("Farm abc", new Address()));
    }

//    @GetMapping("/{userId}/add-address-farm/{farmId}")
//    public Farm addAddressFarm(@PathVariable Long userId, @PathVariable Long farmId) {
//        return farmService.addAddressToFarm(farmId, new Address());
//    }
//
//    @GetMapping("/{userId}/delete-address-farm/{farmId}")
//    public Farm deleteAddressFarm(@PathVariable Long userId, @PathVariable Long farmId) {
//        return farmService.deleteAddressOfFarm(farmId);
//    }
}
