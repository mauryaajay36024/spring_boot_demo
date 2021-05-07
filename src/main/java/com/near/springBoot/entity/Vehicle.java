package com.near.springBoot.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Document(collection= "vehicle9")
public class Vehicle {
  @Id
  @GeneratedValue
  private String id;
  private String regNo;
  private String colour;

  public Vehicle() {
  }

  public Vehicle(String regNo, String colour) {
    this.regNo = regNo;
    this.colour = colour;
  }

  public String getId() {
    return id;
  }

  public void setId(String  id) {
    this.id = id;
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
    return "id=" + id +
        ", regNo='" + regNo + '\'' +
        ", colour='" + colour ;
  }
}

