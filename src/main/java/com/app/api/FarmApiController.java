package com.app.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Address;
import com.app.entity.Farm;
import com.app.service.FarmService;
import com.common.util.ErrorUtils;

@RestController
public class FarmApiController {
	
	@Autowired
    private FarmService farmService;
	
//  Add farm to user
  @RequestMapping(value = "/{userId}/add-farm", method = RequestMethod.POST)
  public String addFarm(@PathVariable Long userId, @Valid @RequestBody Farm farm, BindingResult result) {
      if (result.hasErrors()) {
          return ErrorUtils.customErrors(result.getAllErrors());
      } else {
          return farmService.addFarmToUser(userId, new Farm("Farm 1", new Address()));
      }

  }

  //    Get farm of user
  @RequestMapping(value = "/{userId}/get-farm/{farmId}",method = RequestMethod.GET)
  public Farm getFarm(@PathVariable Long userId, @PathVariable Long farmId) {
      return farmService.getFarm(farmId);
  }

  //    Get alls farm of user
  @RequestMapping(value = "/{userId}/all-farms", method = RequestMethod.GET)
  public String getFarmOfUser(@PathVariable Long userId) {
      return farmService.getFarmOfUser(userId);
  }

  //   Update farm of user
  @RequestMapping(value = "/{userId}/update-farm/{farmId}", method = RequestMethod.PUT)
  public String getFarmOfUser(@PathVariable Long userId, @PathVariable Long farmId, @Valid @RequestBody Farm farm, BindingResult result) {
      if (result.hasErrors()) {
          return ErrorUtils.customErrors(result.getAllErrors());
      } else {
          return farmService.updateFarm(userId, farmId, farm);
      }
  }

  //    Delete farm
  @RequestMapping(value = "/{userId}/delete-farm/{farmId}", method = RequestMethod.DELETE)
  public void deleteFarm(@PathVariable Long userId, @PathVariable Long farmId) {
      farmService.deleteFarm(userId, farmId);
  }

}
