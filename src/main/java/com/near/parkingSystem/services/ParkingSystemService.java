package com.near.parkingSystem.services;
import com.near.parkingSystem.redisDatabase.entity.Vehicle;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface ParkingSystemService {
  List<Vehicle> printVehicleInfo();

  Vehicle addVehicleInfo(Vehicle vehicle);

  Optional<Vehicle> updateVehicleInfo(Long  id, Vehicle vehicle);

  Map<String,Boolean> deleteVehicleInfo(Long id) ;
}
