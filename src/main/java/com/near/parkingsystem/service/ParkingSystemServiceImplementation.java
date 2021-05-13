package com.near.parkingsystem.services;

import com.near.parkingsystem.core.Vehicle;
import com.near.parkingsystem.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ParkingSystemServiceImplementation implements ParkingSystemService {

  @Autowired
  private VehicleRepository vehicleRepository;

  @Override
  public List<Vehicle> printInfo() {
    return vehicleRepository.findAll();
  }

  @Override
  public Vehicle addInfo(Vehicle vehicle) {
    vehicleRepository.save(vehicle);
    return vehicle;
  }

  @Override
  public Vehicle updateInfo(Vehicle vehicle) {
    return vehicleRepository.save(vehicle);
  }

  @Override
  public void deleteInfo(String regNo) {
    Vehicle entity=vehicleRepository.getOne(regNo);
    vehicleRepository.delete(entity);
  }

}
