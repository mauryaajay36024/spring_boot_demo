package com.near.springBoot.services;
import com.near.springBoot.entity.Vehicle;
import java.util.List;


public interface DbService {
  List<Vehicle> printInfo();

  Vehicle addInfo(Vehicle vehicle);

  Vehicle updateInfo(String regNo,Vehicle vehicle);

  void deleteInfo(String regNo);
}
