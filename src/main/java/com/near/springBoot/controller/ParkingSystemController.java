package com.near.springBoot.controller;
import com.near.springBoot.entity.Vehicle;
import com.near.springBoot.services.DbService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
public class ParkingSystemController {

  @Autowired
  private DbService dbService;

  //get all vehicle info
  @GetMapping("/vehicles")
  public List<Vehicle> vehicleInfo(){
    return dbService.printInfo();
  }

  //add vehicle info
  @PostMapping("/vehicles")
  public HttpEntity<HttpStatus> addVehicleInfo(@RequestBody Vehicle vehicle){
    try {
      this.dbService.addInfo(vehicle);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e){
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  //update vehicle info
  @PutMapping("/vehicles/{regNo}")
  public ResponseEntity<HttpStatus> updateVehicle(@PathVariable String regNo,@RequestBody Vehicle vehicle){
    try {
      this.dbService.updateInfo(regNo,vehicle);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e){
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  //Delete vehicle info
  @DeleteMapping("/vehicles/{regNo}")
  public ResponseEntity<HttpStatus> deleteVehicle(@PathVariable String regNo){
    try {
      this.dbService.deleteInfo(regNo);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e){
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
