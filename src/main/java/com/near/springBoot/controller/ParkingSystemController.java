package com.near.springBoot.controller;

import com.near.springBoot.core.Vehicle;
import com.near.springBoot.services.BaseClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParkingSystemController {

  @Autowired
  BaseClient baseClient;

  //get all vehicle info
  @GetMapping("/vehicle")
  public List<Vehicle> vehicleInfo(){

    return baseClient.printInfo();
  }

  //get vehicle info using registration Number
  @GetMapping("/vehicle/{registrationNumber}")
  public Vehicle vehicleInfo(@PathVariable String registrationNumber){

    return this.baseClient.printInfo(registrationNumber);

  }

  @PostMapping("/vehicle")
  public Vehicle addVehicle(@RequestBody Vehicle vehicle){
    return this.baseClient.addInfo(vehicle);
  }

  //update vehicle info
  @PutMapping("/vehicle/{registrationNumber}")
  public Vehicle updateVehicleInfo(@RequestBody Vehicle vehicle,@ PathVariable String registrationNumber){

    return this.baseClient.updateInfo(vehicle,registrationNumber);
  }

  //Delete vehicle info
  @DeleteMapping("/vehicle/{regNo}")
  public Vehicle deleteVehicle(@PathVariable String regNo){

    return this.baseClient.deleteInfo(regNo);

  }

}
