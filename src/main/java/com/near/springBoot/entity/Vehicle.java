package com.near.springBoot.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


@RedisHash("vehicle_info")
public class Vehicle {
  @Id
  private Long id;
  private String regNo;
  private String colour;

  public Vehicle() {
  }

  public Vehicle(String regNo, String colour) {
    this.regNo = regNo;
    this.colour = colour;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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

