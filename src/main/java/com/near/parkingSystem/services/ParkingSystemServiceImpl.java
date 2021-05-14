package com.near.parkingSystem.services;
import com.near.parkingSystem.mongodbDatabase.repository.MongodbRepository;
import com.near.parkingSystem.redisDatabase.entity.Vehicle;
import com.near.parkingSystem.redisDatabase.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;


@Service
public class ParkingSystemServiceImpl implements ParkingSystemService {

  @Autowired
  private RedisRepository redisRepository;

  @Autowired
  private MongodbRepository mongodbRepository;

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

  public static String repositoryName() throws IOException {
    Properties properties=new Properties();
    properties.load(new FileReader("src/main/resources/application.properties"));
    return properties.getProperty("vehicleRepository");
  }


}
