package com.near.springBoot.services;
import com.near.springBoot.core.Vehicle;
import java.util.List;


public interface DbService {
  List<Vehicle> printInfo();

  Vehicle addInfo(Vehicle vehicle);

  Vehicle updateInfo(Vehicle vehicle);

  void deleteInfo(String regNo);
}
