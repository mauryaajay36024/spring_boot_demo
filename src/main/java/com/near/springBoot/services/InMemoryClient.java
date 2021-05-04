package com.near.springBoot.services;

import com.near.springBoot.core.Vehicle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InMemoryClient implements BaseClient{
  List<Vehicle> list;

  public InMemoryClient(){
    list=new ArrayList<>();
    list.add(new Vehicle("DL23AV4497","RED"));
    list.add(new Vehicle("MH11RT5656","WHITE"));

  }
  @Override
  public List<Vehicle> printInfo() {
    return list;
  }

  @Override
  public Vehicle printInfo(String regNo) {
    Vehicle vehicle=null;
    for(Vehicle info:list){
      if(info.getRegNo().equalsIgnoreCase(regNo)){
        vehicle=info;
        break;
      }
    }
    return vehicle;
  }

  @Override
  public Vehicle addInfo(Vehicle vehicle) {
    list.add(vehicle);
    return vehicle;
  }

  @Override
  public Vehicle updateInfo(Vehicle vehicle, String registrationNumber) {
    for(Vehicle info:list){
      if(info.getRegNo().equalsIgnoreCase(registrationNumber)){
        info.setRegNo(vehicle.getRegNo());
        info.setColour(vehicle.getColour());
        break;
      }
    }
    return vehicle;
  }

  @Override
  public Vehicle deleteInfo(String regNo) {
    Vehicle vehicle=null;
    for(Vehicle info:list){
      if(info.getRegNo().equalsIgnoreCase(regNo)){
        list.clear();
        break;
      }
    }
    return vehicle;
  }

}
