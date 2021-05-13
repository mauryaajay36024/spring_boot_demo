package com.near.parkingsystem.service;

import com.near.parkingsystem.entity.Vehicle;
import com.near.parkingsystem.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ParkingSystemServiceImplementation implements ParkingSystemService {

  @Autowired
  private VehicleRepository vehicleRepository;

  @Override
  public List<Vehicle> printVehicleInfo() {
    return vehicleRepository.findAll();
  }

  @Override
  public Vehicle addVehicleInfo(Vehicle vehicle) {
    vehicleRepository.save(vehicle);
    return vehicle;
  }

  @Override
  public Vehicle updateVehicleInfo(Vehicle vehicle) {
    return vehicleRepository.save(vehicle);
  }

  @Override
  public void deleteVehicleInfo(String regNo) {
    Vehicle entity=vehicleRepository.getOne(regNo);
    vehicleRepository.delete(entity);
  }

}
