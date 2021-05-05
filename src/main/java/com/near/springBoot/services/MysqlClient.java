package com.near.springBoot.services;

import com.near.springBoot.core.Vehicle;
import com.near.springBoot.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MysqlClient implements DbService {

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
