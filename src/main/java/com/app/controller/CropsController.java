package com.app.controller;

import com.app.entity.Crops;
import com.app.service.CropsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/crops")
public class CropsController {

    @Autowired
    private CropsService cropsService;

    @GetMapping("/")
    public Iterable<Crops> allCrops() {
        return cropsService.getAllCrops();
    }

    @GetMapping("/add")
    public Crops addCrops() {
        return cropsService.addCrops(new Crops("Crops 1", "Description ABC"));
    }

    @GetMapping("/{cropsId}")
    public Crops addCrops(@PathVariable Long cropsId) {
        return cropsService.getCrops(cropsId);
    }

    @GetMapping("/{cropsId}/update")
    public Crops updateCrops(@PathVariable Long cropsId) {
        return cropsService.updateCrops(cropsId, new Crops("Crops 1 update", "Description ABC update"));
    }
}
