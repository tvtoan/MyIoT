package com.app.controller;

import com.app.entity.Farm;
import com.app.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class WebController {

    @Autowired
    private FarmService farmService;

    @RequestMapping(value = { "/farm" }, method = RequestMethod.GET)
    public String farmPage(Model model) {
        model.addAttribute("farms", farmService.getFarms());
        return "manageFarm";
    }

    @RequestMapping(value = { "/farm/add" }, method = RequestMethod.GET)
    public String addFarmPage(Model model) {
        model.addAttribute("farmForm", new Farm());
        return "addFarm";
    }

    @RequestMapping(value = { "/farm" }, method = RequestMethod.POST)
    public String save(@ModelAttribute("farmForm") @Validated Farm farm, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "addFarm";
        } else {
            System.out.println("Farm=====");
            System.out.println(farm.toString());
            farmService.saveOrUpdateFarm(farm);

            if (farm.isNew()) {
                redirect.addFlashAttribute("msg", "Farm added successfully!");
            } else {
                redirect.addFlashAttribute("msg", "Farm updated successfully!");
            }
            return "manageFarm";
        }
    }

    @RequestMapping(value = {"/farm/{farmId}"}, method = RequestMethod.GET)
    public String getFarm(@PathVariable("farmId") Long farmId, Model model) {
        model.addAttribute("farm", farmService.getFarm(farmId));
        return "farmDetail";
    }

    @RequestMapping(value = {"/farm/{farmId}/update"}, method = RequestMethod.GET)
    public String updateFarm(@PathVariable("farmId") Long farmId, Model model) {
        Farm f = farmService.getFarm(farmId);
        model.addAttribute("farmForm", f);
        return "addFarm";
    }

    @RequestMapping(value = {"/farm/{farmId}/delete"}, method = RequestMethod.GET)
    public String delete(@PathVariable("farmId") Long farmId, RedirectAttributes redirect) {
        farmService.deleteFarm(farmId);
        redirect.addFlashAttribute("msg", "Deleted farm successfully");
        return "redirect:/farm";
    }

    //    For page ajax
    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public String farmAjaxPage() {
        return "farmAjax";
    }
}
