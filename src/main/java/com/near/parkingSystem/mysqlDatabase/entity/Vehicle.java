package com.near.parkingSystem.mysqlDatabase.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parking_system",schema = "near")
public class Vehicle {
  @Id
  private String regNo;
  private String colour;

  public Vehicle() {
  }
  public Vehicle(String regNo, String colour) {
    this.regNo = regNo;
    this.colour = colour;
  }

  public String getRegNo() {
    return regNo;
  }
  public void setRegNo(String regNo) {
    this.regNo = regNo;
  }
  public String getColour() {
    return colour;
  }
  public void setColour(String colour) {
    this.colour = colour;
  }

  @Override
  public String toString() {
    return "\nVehicle Registration No:" + regNo + "\nVehicle Colour:" + colour;
  }



}