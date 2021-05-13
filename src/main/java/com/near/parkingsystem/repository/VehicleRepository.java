package com.near.parkingsystem.repository;
import com.near.parkingsystem.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,String> {

}
