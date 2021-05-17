package com.near.parkingSystem.mysqlDatabase.repository;

import com.near.parkingSystem.mysqlDatabase.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MysqlRepository extends JpaRepository<Vehicle,String> {

}