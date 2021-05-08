package com.near.springBoot.services;
import com.near.springBoot.entity.Vehicle;
import com.near.springBoot.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Service
public class RedisClient implements DbService {

  @Autowired
  private RedisRepository redisRepository;

  @Override
  public Iterable<Vehicle> printInfo() {

    return redisRepository.findAll();
  }

  @Override
  public Vehicle addInfo(Vehicle vehicle) {
    redisRepository.save(vehicle);
    return vehicle;
  }

  @Override
  public Optional<Vehicle> updateInfo(Long  id,Vehicle vehicleDetails){
     Optional<Vehicle> veh = redisRepository.findById(id);
     if(veh.isPresent()){
       Vehicle vehicle=veh.get();
       vehicle.setRegNo(vehicleDetails.getRegNo());
       vehicle.setColour(vehicleDetails.getColour());
       redisRepository.save(vehicle);
     }
     return veh;

  }

  @Override
  public Map<String, Boolean> deleteInfo(Long id) {
    Optional<Vehicle> veh=redisRepository.findById(id);
    Vehicle vehicle=veh.get();
    redisRepository.delete(vehicle);
    Map<String,Boolean> response=new HashMap<>();
    response.put("Data Deleted",Boolean.TRUE);
    return response;


  }


}
