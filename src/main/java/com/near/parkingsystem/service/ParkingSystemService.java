package com.near.parkingsystem.services;
import com.near.parkingsystem.core.Vehicle;

import java.util.List;


public interface ParkingSystemService {
  List<Vehicle> printInfo();

  Vehicle addInfo(Vehicle vehicle);

  Vehicle updateInfo(Vehicle vehicle);

  void deleteInfo(String regNo);
}
