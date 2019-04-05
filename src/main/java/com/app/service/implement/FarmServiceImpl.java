package com.app.service.implement;

import com.app.entity.Address;
import com.app.entity.Farm;
import com.app.entity.User;
import com.app.repository.AddressRepository;
import com.app.repository.FarmRepository;
import com.app.repository.UserRepository;
import com.app.service.FarmService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FarmServiceImpl implements FarmService {

    @Autowired
    private FarmRepository farmRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Farm getFarm(Long farmId) {
        return farmRepository.findById(farmId).get();
    }

    @Override
    public String addFarmToUser(Long userId, Farm farm) {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("status", "success");
            jsonObject.put("title", "Added successfully");
            User user = userRepository.findById(userId).get();
            farm.setUser(user);
            Farm f = farmRepository.save(farm);
            jsonObject.put("messages", "#" + f.getFarmId() + "\t" + f.getDescription() + ", userId: " + f.getUser().getUserId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    @Override
    @Transactional
    public String getFarmOfUser(Long userId) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("status", "success");
            jsonObject.put("title", "Getted successfully");
            Iterable<Farm> f = farmRepository.getFarmOfUser(userRepository.findById(userId).get());
            jsonObject.put("data", f);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    @Override
    public String updateFarm(Long userId, Long farmId, Farm farmRequest) {
        JSONObject jsonObject = new JSONObject();
        try {
            if (!farmRepository.existsByFarmIdAndUserUserId(farmId, userId)) {
                jsonObject.put("status", "failed");
                jsonObject.put("title", "Updated fail");
                jsonObject.put("messages", "Farm not exists");
            } else {
                farmRepository.save(farmRequest);
                jsonObject.put("status", "success");
                jsonObject.put("title", "Updated successfully");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    @Override
    public String deleteFarm(Long userId, Long farmId) {
        Farm f = farmRepository.findByFarmIdAndUserUserId(farmId, userId).get();
        farmRepository.delete(f);
        System.out.println("Delete farm done.");
        JSONObject jsonObject = new JSONObject();
        try {
            if (!farmRepository.existsByFarmIdAndUserUserId(farmId, userId)) {
                jsonObject.put("status", "failed");
                jsonObject.put("title", "Updated fail");
                jsonObject.put("messages", "Farm not exists");
            } else {
                farmRepository.deleteById(farmId);
                jsonObject.put("status", "success");
                jsonObject.put("title", "Updated successfully");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    @Override
    public boolean checkExistsFarm(Long farmId) {
        return farmRepository.existsById(farmId);
    }

    @Override
    public Iterable<Farm> getFarms() {
        return farmRepository.findAll();
    }

    @Override
    public Farm saveOrUpdateFarm(Farm farm) {
//        if (farmRepository.findById(farm.getFarmId())==null) {
//            return farmRepository.save(farm);
//        } else {
//            return farmRepository.
//        }
        return farmRepository.save(farm);
    }

    @Override
    public void deleteFarm(Long farmId) {
        farmRepository.deleteById(farmId);
    }

    @Override
    public String save(Farm farm) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("status", "success");
            jsonObject.put("title", "Updated successfully");
            Farm caTmp = farmRepository.save(farm);
            jsonObject.put("messages", "#" + caTmp.getFarmId() + "\t" + caTmp.getDescription());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
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
