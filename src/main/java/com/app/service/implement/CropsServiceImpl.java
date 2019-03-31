package com.app.service.implement;

import com.app.entity.Crops;
import com.app.repository.CropsRepository;
import com.app.service.CropsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CropsServiceImpl implements CropsService {

    @Autowired
    private CropsRepository cropsRepository;

    @Override
    public Crops addCrops(Crops crops) {
        return cropsRepository.save(crops);
    }

    @Override
    public Iterable<Crops> getAllCrops() {
        return cropsRepository.findAll();
    }

    @Override
    public Crops getCrops(Long cropsId) {
        return cropsRepository.findById(cropsId).get();
    }

    @Override
    public Crops updateCrops(Long cropsId, Crops cropsRequest) {
        if (cropsRepository.existsById(cropsId)) {
            Crops c = cropsRepository.findById(cropsId).get();
            c.setName(cropsRequest.getName());
            c.setDescription(cropsRequest.getDescription());
            return cropsRepository.save(c);
        }
        return null;
    }

    @Override
    public void deleteCrops(Long cropsId) {
        cropsRepository.deleteById(cropsId);
    }
}
