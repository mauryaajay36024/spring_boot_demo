package com.near.springBoot.services;
import com.near.springBoot.entity.Vehicle;
import com.near.springBoot.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Service
public class ElasticsearchClient implements DbService {

  @Autowired
  private VehicleRepository vehicleRepository;

  @Override
  public Iterable<Vehicle> printInfo() {

    return vehicleRepository.findAll();
  }

  @Override
  public Vehicle addInfo(Vehicle vehicle) {
    vehicleRepository.save(vehicle);
    return vehicle;
  }

  @Override
  public Optional<Vehicle> updateInfo(String  id,Vehicle vehicleDetails){
     Optional<Vehicle> veh = vehicleRepository.findById(id);
     if(veh.isPresent()){
       Vehicle vehicle=veh.get();
       vehicle.setRegNo(vehicleDetails.getRegNo());
       vehicle.setColour(vehicleDetails.getColour());
       vehicleRepository.save(vehicle);
     }
     return veh;

  }

  @Override
  public Map<String, Boolean> deleteInfo(String id) {
    Optional<Vehicle> veh=vehicleRepository.findById(id);
    Vehicle vehicle=veh.get();
    vehicleRepository.delete(vehicle);
    Map<String,Boolean> response=new HashMap<>();
    response.put("Data Deleted",Boolean.TRUE);
    return response;


  }


}
