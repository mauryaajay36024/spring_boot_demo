package com.near.parkingSystem.services;
import com.near.parkingSystem.mysqlDatabase.repository.MysqlRepository;
import com.near.parkingSystem.redisDatabase.entity.Vehicle;
import com.near.parkingSystem.mysqlDatabase.entity.*;
import com.near.parkingSystem.redisDatabase.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ParkingSystemServiceImpl implements ParkingSystemService {

  @Autowired
  private RedisRepository redisRepository;

  @Autowired
  private MysqlRepository mysqlRepository;

  @Override
  public List<Vehicle> printVehicleInfo() {

    return (List<Vehicle>) redisRepository.findAll();
  }

  @Override
  public Vehicle addVehicleInfo(Vehicle vehicle) {
    redisRepository.save(vehicle);
    return vehicle;
  }

  @Override
  public Optional<Vehicle> updateVehicleInfo(Long  id,Vehicle vehicleDetails){
     Optional<Vehicle> optionalVehicle = redisRepository.findById(id);
     if(optionalVehicle.isPresent()){
       Vehicle vehicle=optionalVehicle.get();
       vehicle.setRegNo(vehicleDetails.getRegNo());
       vehicle.setColour(vehicleDetails.getColour());
       redisRepository.save(vehicle);
     }
     return optionalVehicle;

  }

  @Override
  public Map<String, Boolean> deleteVehicleInfo(Long id) {
    Optional<Vehicle> optionalVehicle=redisRepository.findById(id);
    Vehicle vehicle=optionalVehicle.get();
    redisRepository.delete(vehicle);
    Map<String,Boolean> response=new HashMap<>();
    response.put("Data Deleted",Boolean.TRUE);
    return response;
  }

}
