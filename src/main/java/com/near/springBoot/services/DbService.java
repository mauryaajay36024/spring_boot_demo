package com.near.springBoot.services;
import com.near.springBoot.entity.Vehicle;
import java.util.Map;
import java.util.Optional;


public interface DbService {
  Iterable<Vehicle> printInfo();

  Vehicle addInfo(Vehicle vehicle);

  Optional<Vehicle> updateInfo(String  id, Vehicle vehicle);

  Map<String,Boolean> deleteInfo(String id) ;
}
