package com.near.springBoot.services;

import com.near.springBoot.core.Vehicle;

import java.util.List;

public interface BaseClient {
  List<Vehicle> printInfo();

  Vehicle printInfo(String regNo);

  Vehicle addInfo(Vehicle vehicle);

  Vehicle updateInfo(Vehicle vehicle, String registrationNumber);

  Vehicle deleteInfo(String regNo);
}
