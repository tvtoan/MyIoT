package com.app.service.implement;

import com.app.entity.Address;
import com.app.entity.Farm;
import com.app.entity.User;
import com.app.repository.AddressRepository;
import com.app.repository.FarmRepository;
import com.app.repository.UserRepository;
import com.app.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FarmServiceImpl implements FarmService {

    @Autowired
    private FarmRepository farmRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Farm addFarmToUser(Long userId, Farm farm) {
        User user = userRepository.findById(userId).get();
        farm.setUser(user);
        return farmRepository.save(farm);
    }

    @Override
    public Farm getFarm(Long farmId) {
        return farmRepository.findById(farmId).get();
    }

    @Override
    @Transactional
    public Iterable<Farm> getFarmOfUser(Long userId) {
        return farmRepository.getFarmOfUser(userRepository.findById(userId).get());
    }

    @Override
    public Farm updateFarm(Long userId, Long farmId, Farm farmRequest) {
        if (!farmRepository.existsByFarmIdAndUserUserId(farmId, userId)) {
            System.out.println("Farm no exist.");
            return null;
        }
        Farm f = farmRepository.findById(farmId).get();
        f.setDescription(farmRequest.getDescription());
        System.out.println("Update farm done.");
        return farmRepository.save(f);
    }

    @Override
    public void deleteFarm(Long userId, Long farmId) {
        Farm f = farmRepository.findByFarmIdAndUserUserId(farmId, userId).get();
        farmRepository.delete(f);
        System.out.println("Delete farm done.");
    }

    @Override
    public boolean checkExistsFarm(Long farmId) {
        return farmRepository.existsById(farmId);
    }

//    @Override
//    public Farm addAddressToFarm(Long farmId, Address address) {
//        Farm f = farmRepository.findById(farmId).get();
//        f.setAddress(address);
//        address.setFarm(f);
//        return farmRepository.save(f);
//    }
//
//    @Override
//    public Farm deleteAddressOfFarm(Long farmId) {
//        Farm f = farmRepository.findById(farmId).get();
//        addressRepository.deleteById(f.getAddress().getAddressId());
//        return f;
//    }
}
