package com.near.parkingSystem.controller;
import com.near.parkingSystem.redisDatabase.entity.Vehicle;
import com.near.parkingSystem.services.ParkingSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
public class ParkingSystemController {

  @Autowired
  private ParkingSystemService parkingSystemService;

  //get all vehicle info
  @GetMapping("/vehicles")
  public List<Vehicle> displayVehicleInfo() {
    return parkingSystemService.printVehicleInfo();
  }

  //add vehicle info
  @PostMapping("/vehicles")
  public HttpEntity<String> addVehicleInfoToDatabase(@RequestBody Vehicle vehicle) {
    try {
      this.parkingSystemService.addVehicleInfo(vehicle);
      return new ResponseEntity<>("Vehicle details added to the database",HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  //update vehicle info
  @PutMapping("/vehicles/{id}")
  public Optional<Vehicle> updateVehicleInfoInDatabase(@PathVariable Long id, @RequestBody Vehicle vehicle) {
    return this.parkingSystemService.updateVehicleInfo(id, vehicle);
  }

  //Delete vehicle info
  @DeleteMapping("/vehicles/{id}")
  public Map<String, Boolean> deleteVehicleInfoFromDatabase(@PathVariable Long id) {
    return this.parkingSystemService.deleteVehicleInfo(id);
  }
}
