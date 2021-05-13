package com.near.parkingsystem.service;
import com.near.parkingsystem.entity.Vehicle;

import java.util.List;


public interface ParkingSystemService {
  List<Vehicle> printVehicleInfo();

  Vehicle addVehicleInfo(Vehicle vehicle);

  Vehicle updateVehicleInfo(Vehicle vehicle);

  void deleteVehicleInfo(String regNo);
}
