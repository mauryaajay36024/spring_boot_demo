package com.near.springBoot.controller;
import com.near.springBoot.entity.Vehicle;
import com.near.springBoot.services.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;


@RestController
public class ParkingSystemController {

  @Autowired
  private DbService dbService;

  //get all vehicle info
  @GetMapping("/vehicles")
  public Iterable<Vehicle> vehicleInfo() {
    return dbService.printInfo();
  }

  //add vehicle info
  @PostMapping("/vehicles")
  public HttpEntity<String> addVehicleInfo(@RequestBody Vehicle vehicle) {
    try {
      this.dbService.addInfo(vehicle);
      return new ResponseEntity<>("Vehicle details added to the database",HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  //update vehicle info
  @PutMapping("/vehicles/{id}")
  public Optional<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
    return this.dbService.updateInfo(id, vehicle);
  }


  //Delete vehicle info
  @DeleteMapping("/vehicles/{id}")
  public Map<String, Boolean> deleteVehicle(@PathVariable Long id) {
    return this.dbService.deleteInfo(id);
  }
}
